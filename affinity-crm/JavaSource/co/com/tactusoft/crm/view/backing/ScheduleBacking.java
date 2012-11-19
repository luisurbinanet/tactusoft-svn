package co.com.tactusoft.crm.view.backing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class ScheduleBacking implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean disabledButton;
	private String destination = "D:\\tmp\\";
	private String fileName;

	public ScheduleBacking() {
		disabledButton = true;
	}

	public boolean isDisabledButton() {
		return disabledButton;
	}

	public void setDisabledButton(boolean disabledButton) {
		this.disabledButton = disabledButton;
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		disabledButton = false;

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

	public void executeAction(ActionEvent event) {
		StringBuilder text = new StringBuilder();
		String NL = System.getProperty("line.separator");
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(fileName));
			while (scanner.hasNextLine()) {
				text.append(scanner.nextLine() + NL);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}

	}

}
