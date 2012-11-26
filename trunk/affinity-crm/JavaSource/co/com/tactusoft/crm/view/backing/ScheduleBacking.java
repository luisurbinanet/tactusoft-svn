package co.com.tactusoft.crm.view.backing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.ScheduleBranch;

@Named
@Scope("view")
public class ScheduleBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean disabledButton;
	private boolean disabledExecuteButton;

	private String destination = "/Users/CSARMIENTO/dumps/";
	private String fileName;
	private List<ScheduleBranch> listScheduleBranch;

	private String mode;

	public ScheduleBacking() {
		disabledButton = true;
		disabledExecuteButton = true;
		mode = Constant.SCHEDULE_MAINTAIN;
	}

	public boolean isDisabledButton() {
		return disabledButton;
	}

	public void setDisabledButton(boolean disabledButton) {
		this.disabledButton = disabledButton;
	}

	public boolean isDisabledExecuteButton() {
		return disabledExecuteButton;
	}

	public void setDisabledExecuteButton(boolean disabledExecuteButton) {
		this.disabledExecuteButton = disabledExecuteButton;
	}

	public List<ScheduleBranch> getListScheduleBranch() {
		return listScheduleBranch;
	}

	public void setListScheduleBranch(List<ScheduleBranch> listScheduleBranch) {
		this.listScheduleBranch = listScheduleBranch;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void handleFileUpload(FileUploadEvent event) {
		String message = FacesUtil.getMessage("file_msg_upload", event
				.getFile().getFileName());

		FacesUtil.addInfo(message);
		disabledButton = false;
		disabledExecuteButton = true;
		try {
			fileName = destination + event.getFile().getFileName();
			copyFile(fileName, event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void analyzeAction(ActionEvent event) {
		listScheduleBranch = new ArrayList<ScheduleBranch>();
		File file = new File(fileName);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			// repeat until all lines is read
			while ((text = reader.readLine()) != null) {
				ScheduleBranch scheduleBranch = new ScheduleBranch();
				scheduleBranch.setState(1);

				String[] columns = text.split(";");
				scheduleBranch.setLine(text);
				if (columns.length == 5) {
					BigDecimal idDoctor = null;
					Integer day = 0;
					Date startHour = null;
					Date endHour = null;
					BigDecimal idBranch = null;

					try {
						idDoctor = new BigDecimal(columns[0]);
					} catch (Exception ex) {
						scheduleBranch.setMessage("Columna Doctor inválido");
						scheduleBranch.setState(0);
					}

					if (scheduleBranch.getState() == 1) {
						try {
							day = Integer.parseInt(columns[1]);
						} catch (Exception ex) {
							scheduleBranch.setMessage("Columna Día inválido");
							scheduleBranch.setState(0);
						}
					}

					if (scheduleBranch.getState() == 1) {
						startHour = FacesUtil
								.stringTOSDate(columns[2], "HH:mm");
						if (startHour == null) {
							scheduleBranch
									.setMessage("Columna Hora Inicial inválido");
							scheduleBranch.setState(0);
						}
					}

					if (scheduleBranch.getState() == 1) {
						endHour = FacesUtil.stringTOSDate(columns[3], "HH:mm");
						if (endHour == null) {
							scheduleBranch
									.setMessage("Columna Hora Final inválido");
							scheduleBranch.setState(0);
						}
					}

					if (scheduleBranch.getState() == 1) {
						try {
							idBranch = new BigDecimal(columns[4]);
						} catch (Exception ex) {
							scheduleBranch
									.setMessage("Columna Sucursal inválido");
							scheduleBranch.setState(0);
						}
					}

					if (scheduleBranch.getState() == 1) {
						CrmDoctorSchedule crmDoctorSchedule = new CrmDoctorSchedule();
						crmDoctorSchedule.setDay(day);
						crmDoctorSchedule.setStartHour(startHour);
						crmDoctorSchedule.setEndHour(endHour);

						CrmDoctor crmDctor = new CrmDoctor();
						crmDctor.setId(idDoctor);
						crmDoctorSchedule.setCrmDoctor(crmDctor);

						CrmBranch crmBranch = new CrmBranch();
						crmBranch.setId(idBranch);
						crmDoctorSchedule.setCrmBranch(crmBranch);
						scheduleBranch.setCrmDoctorSchedule(crmDoctorSchedule);

						scheduleBranch.setMessage("Listo para Procesar");
						disabledExecuteButton = false;
					}
				} else {
					scheduleBranch
							.setMessage("El número de columnas no corresponde al mínimo requerido (Doctor, Día, Hora Inicial, Hora Final, Sucursal)");
					scheduleBranch.setState(0);
				}
				listScheduleBranch.add(scheduleBranch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void executeAction(ActionEvent event) {

		for (ScheduleBranch row : listScheduleBranch) {
			if (row.getState() == 1) {
			}
		}

	}

}
