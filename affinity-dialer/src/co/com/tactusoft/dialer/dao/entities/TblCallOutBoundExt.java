package co.com.tactusoft.dialer.dao.entities;

import java.io.Serializable;
import java.util.Date;

public class TblCallOutBoundExt implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idCallOutBoundExt;
	private Long idUsuarioWeb;
	private String stNombre;
	private String stTelefono;
	private String stTelefonoMovil;
	private Integer idCall;
	private Date dtFecha;

	public TblCallOutBoundExt() {

	}

	public Long getIdCallOutBoundExt() {
		return idCallOutBoundExt;
	}

	public void setIdCallOutBoundExt(Long idCallOutBoundExt) {
		this.idCallOutBoundExt = idCallOutBoundExt;
	}

	public Long getIdUsuarioWeb() {
		return idUsuarioWeb;
	}

	public void setIdUsuarioWeb(Long idUsuarioWeb) {
		this.idUsuarioWeb = idUsuarioWeb;
	}

	public String getStNombre() {
		return stNombre;
	}

	public void setStNombre(String stNombre) {
		this.stNombre = stNombre;
	}

	public String getStTelefono() {
		return stTelefono;
	}

	public void setStTelefono(String stTelefono) {
		this.stTelefono = stTelefono;
	}

	public String getStTelefonoMovil() {
		return stTelefonoMovil;
	}

	public void setStTelefonoMovil(String stTelefonoMovil) {
		this.stTelefonoMovil = stTelefonoMovil;
	}

	public Integer getIdCall() {
		return idCall;
	}

	public void setIdCall(Integer idCall) {
		this.idCall = idCall;
	}

	public Date getDtFecha() {
		return dtFecha;
	}

	public void setDtFecha(Date dtFecha) {
		this.dtFecha = dtFecha;
	}

}
