package co.com.tactusoft.crm.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CrmSapMedicationDistinct implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String idBill;
	private String idPatient;
	private String typeBill;
	private Date dateBill;

	public CrmSapMedicationDistinct() {

	}

	/**
	 * @param idBill
	 * @param idPatient
	 * @param dateBill
	 */
	public CrmSapMedicationDistinct(String idBill, String idPatient,
			String typeBill, Date dateBill) {
		super();
		this.idBill = idBill;
		this.idPatient = idPatient;
		this.typeBill = typeBill;
		this.dateBill = dateBill;
	}

	@Id
	@Column(name = "id_bill", nullable = false, length = 30)
	public String getIdBill() {
		return this.idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	@Column(name = "id_patient", length = 10)
	public String getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	@Column(name = "type_bill", length = 4)
	public String getTypeBill() {
		return this.typeBill;
	}

	public void setTypeBill(String typeBill) {
		this.typeBill = typeBill;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_bill", length = 19)
	public Date getDateBill() {
		return this.dateBill;
	}

	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}

}
