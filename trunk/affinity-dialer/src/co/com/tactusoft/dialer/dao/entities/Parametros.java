package co.com.tactusoft.dialer.dao.entities;

public class Parametros {

	private String estados;
	private int tiempo;
	private String terminar;
	private String cola;

	public Parametros() {

	}

	public Parametros(String estados, int tiempo, String terminar, String cola) {
		this.estados = estados;
		this.tiempo = tiempo;
		this.terminar = terminar;
		this.cola = cola;
	}

	public String getEstados() {
		return estados;
	}

	public void setEstados(String estados) {
		this.estados = estados;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getTerminar() {
		return terminar;
	}

	public void setTerminar(String terminar) {
		this.terminar = terminar;
	}

	public String getCola() {
		return cola;
	}

	public void setCola(String cola) {
		this.cola = cola;
	}

}
