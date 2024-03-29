package com.tacticlogistics.model.entities;
// Generated 23-ago-2015 19:13:34 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * CausalesAnulacionOrdenTrabajo generated by hbm2java
 */
@Entity
@Table(name = "Causales_Anulacion_Orden_Trabajo", schema = "demo", catalog = "esbTactic", uniqueConstraints = @UniqueConstraint(columnNames = "Codigo") )
public class CausalesAnulacionOrdenTrabajo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private Set<OrdenesTrabajo> ordenesTrabajos = new HashSet<OrdenesTrabajo>(0);

	public CausalesAnulacionOrdenTrabajo() {
	}

	public CausalesAnulacionOrdenTrabajo(Integer id, String codigo, String nombre, String descripcion,
			Date fechaModificacion, String usuarioModificacion) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public CausalesAnulacionOrdenTrabajo(Integer id, String codigo, String nombre, String descripcion,
			Date fechaModificacion, String usuarioModificacion, Set<OrdenesTrabajo> ordenesTrabajos) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.ordenesTrabajos = ordenesTrabajos;
	}

	@Id

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Codigo", unique = true, nullable = false, length = 50)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "Nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Descripcion", nullable = false, length = 200)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Fecha_Modificacion", nullable = false, length = 23)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Column(name = "Usuario_Modificacion", nullable = false, length = 50)
	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "causalesAnulacionOrdenTrabajo")
	public Set<OrdenesTrabajo> getOrdenesTrabajos() {
		return this.ordenesTrabajos;
	}

	public void setOrdenesTrabajos(Set<OrdenesTrabajo> ordenesTrabajos) {
		this.ordenesTrabajos = ordenesTrabajos;
	}

}
