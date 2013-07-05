package co.com.tactusoft.dialer.dao.entities;

import java.io.Serializable;

public class CatTipoLlamada implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idTipoLlamada;
	private String tipoLlamada;

	public CatTipoLlamada() {

	}

	public CatTipoLlamada(Long idTipoLlamada, String tipoLlamada) {
		this.idTipoLlamada = idTipoLlamada;
		this.tipoLlamada = tipoLlamada;
	}

	public Long getIdTipoLlamada() {
		return idTipoLlamada;
	}

	public void setIdTipoLlamada(Long idTipoLlamada) {
		this.idTipoLlamada = idTipoLlamada;
	}

	public String getTipoLlamada() {
		return tipoLlamada;
	}

	public void setTipoLlamada(String tipoLlamada) {
		this.tipoLlamada = tipoLlamada;
	}

}
