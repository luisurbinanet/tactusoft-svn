package com.tacticlogistics.model.entities;
// Generated 23-ago-2015 19:13:34 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * OrdenesTrabajo generated by hbm2java
 */
@Entity
@Table(name = "Ordenes_Trabajo", schema = "demo", catalog = "esbTactic", uniqueConstraints = @UniqueConstraint(columnNames = "Identificador") )
public class OrdenesTrabajo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private CausalesAnulacionOrdenTrabajo causalesAnulacionOrdenTrabajo;
	private EstadosOrdenTrabajo estadosOrdenTrabajo;
	private String identificador;
	private char idTipoTransaccion;
	private String idCliente;
	private String idPais;
	private String idCiudad;
	private String idBodega;
	private Byte prioridad;
	private String numeroOrdenTrabajo;
	private String numeroOrdenRevision;
	private String idTipoOrdenTrabajo;
	private String idProducto;
	private String numeroLote;
	private Integer cantidad;
	private String idUnidadMedida;
	private Integer cantidadEstandar;
	private String idUnidadMedidaEstandar;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private Set<LineasOrdenTrabajo> lineasOrdenTrabajos = new HashSet<LineasOrdenTrabajo>(0);

	public OrdenesTrabajo() {
	}

	public OrdenesTrabajo(Integer id, EstadosOrdenTrabajo estadosOrdenTrabajo, String identificador,
			char idTipoTransaccion, String idCliente, String numeroOrdenTrabajo, String idProducto,
			String numeroLote, Integer cantidad, String idUnidadMedida, Integer cantidadEstandar,
			String idUnidadMedidaEstandar, Date fechaModificacion, String usuarioModificacion) {
		this.id = id;
		this.estadosOrdenTrabajo = estadosOrdenTrabajo;
		this.identificador = identificador;
		this.idTipoTransaccion = idTipoTransaccion;
		this.idCliente = idCliente;
		this.numeroOrdenTrabajo = numeroOrdenTrabajo;
		this.idProducto = idProducto;
		this.numeroLote = numeroLote;
		this.cantidad = cantidad;
		this.idUnidadMedida = idUnidadMedida;
		this.cantidadEstandar = cantidadEstandar;
		this.idUnidadMedidaEstandar = idUnidadMedidaEstandar;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public OrdenesTrabajo(Integer id, CausalesAnulacionOrdenTrabajo causalesAnulacionOrdenTrabajo,
			EstadosOrdenTrabajo estadosOrdenTrabajo, String identificador, char idTipoTransaccion,
			String idCliente, String idPais, String idCiudad, String idBodega, Byte prioridad,
			String numeroOrdenTrabajo, String numeroOrdenRevision, String idTipoOrdenTrabajo,
			String idProducto, String numeroLote, Integer cantidad, String idUnidadMedida,
			Integer cantidadEstandar, String idUnidadMedidaEstandar, Date fechaModificacion,
			String usuarioModificacion, Set<LineasOrdenTrabajo> lineasOrdenTrabajos) {
		this.id = id;
		this.causalesAnulacionOrdenTrabajo = causalesAnulacionOrdenTrabajo;
		this.estadosOrdenTrabajo = estadosOrdenTrabajo;
		this.identificador = identificador;
		this.idTipoTransaccion = idTipoTransaccion;
		this.idCliente = idCliente;
		this.idPais = idPais;
		this.idCiudad = idCiudad;
		this.idBodega = idBodega;
		this.prioridad = prioridad;
		this.numeroOrdenTrabajo = numeroOrdenTrabajo;
		this.numeroOrdenRevision = numeroOrdenRevision;
		this.idTipoOrdenTrabajo = idTipoOrdenTrabajo;
		this.idProducto = idProducto;
		this.numeroLote = numeroLote;
		this.cantidad = cantidad;
		this.idUnidadMedida = idUnidadMedida;
		this.cantidadEstandar = cantidadEstandar;
		this.idUnidadMedidaEstandar = idUnidadMedidaEstandar;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.lineasOrdenTrabajos = lineasOrdenTrabajos;
	}

	@Id

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id_Causal_Anulacion_Orden_Trabajo")
	public CausalesAnulacionOrdenTrabajo getCausalesAnulacionOrdenTrabajo() {
		return this.causalesAnulacionOrdenTrabajo;
	}

	public void setCausalesAnulacionOrdenTrabajo(CausalesAnulacionOrdenTrabajo causalesAnulacionOrdenTrabajo) {
		this.causalesAnulacionOrdenTrabajo = causalesAnulacionOrdenTrabajo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id_Estado_Orden_Trabajo", nullable = false)
	public EstadosOrdenTrabajo getEstadosOrdenTrabajo() {
		return this.estadosOrdenTrabajo;
	}

	public void setEstadosOrdenTrabajo(EstadosOrdenTrabajo estadosOrdenTrabajo) {
		this.estadosOrdenTrabajo = estadosOrdenTrabajo;
	}

	@Column(name = "Identificador", unique = true, nullable = false)
	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Column(name = "Id_Tipo_Transaccion", nullable = false, length = 1)
	public char getIdTipoTransaccion() {
		return this.idTipoTransaccion;
	}

	public void setIdTipoTransaccion(char idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
	}

	@Column(name = "Id_Cliente", nullable = false)
	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	@Column(name = "Id_Pais")
	public String getIdPais() {
		return this.idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	@Column(name = "Id_Ciudad")
	public String getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	@Column(name = "Id_Bodega")
	public String getIdBodega() {
		return this.idBodega;
	}

	public void setIdBodega(String idBodega) {
		this.idBodega = idBodega;
	}

	@Column(name = "Prioridad")
	public Byte getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(Byte prioridad) {
		this.prioridad = prioridad;
	}

	@Column(name = "Numero_Orden_Trabajo", nullable = false, length = 20)
	public String getNumeroOrdenTrabajo() {
		return this.numeroOrdenTrabajo;
	}

	public void setNumeroOrdenTrabajo(String numeroOrdenTrabajo) {
		this.numeroOrdenTrabajo = numeroOrdenTrabajo;
	}

	@Column(name = "Numero_Orden_Revision", length = 10)
	public String getNumeroOrdenRevision() {
		return this.numeroOrdenRevision;
	}

	public void setNumeroOrdenRevision(String numeroOrdenRevision) {
		this.numeroOrdenRevision = numeroOrdenRevision;
	}

	@Column(name = "Id_Tipo_Orden_Trabajo")
	public String getIdTipoOrdenTrabajo() {
		return this.idTipoOrdenTrabajo;
	}

	public void setIdTipoOrdenTrabajo(String idTipoOrdenTrabajo) {
		this.idTipoOrdenTrabajo = idTipoOrdenTrabajo;
	}

	@Column(name = "Id_Producto", nullable = false)
	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	@Column(name = "Numero_Lote", nullable = false)
	public String getNumeroLote() {
		return this.numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	@Column(name = "Cantidad", nullable = false)
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "Id_Unidad_Medida", nullable = false)
	public String getIdUnidadMedida() {
		return this.idUnidadMedida;
	}

	public void setIdUnidadMedida(String idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	@Column(name = "Cantidad_Estandar", nullable = false)
	public Integer getCantidadEstandar() {
		return this.cantidadEstandar;
	}

	public void setCantidadEstandar(Integer cantidadEstandar) {
		this.cantidadEstandar = cantidadEstandar;
	}

	@Column(name = "Id_Unidad_Medida_Estandar", nullable = false)
	public String getIdUnidadMedidaEstandar() {
		return this.idUnidadMedidaEstandar;
	}

	public void setIdUnidadMedidaEstandar(String idUnidadMedidaEstandar) {
		this.idUnidadMedidaEstandar = idUnidadMedidaEstandar;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordenesTrabajo")
	public Set<LineasOrdenTrabajo> getLineasOrdenTrabajos() {
		return this.lineasOrdenTrabajos;
	}

	public void setLineasOrdenTrabajos(Set<LineasOrdenTrabajo> lineasOrdenTrabajos) {
		this.lineasOrdenTrabajos = lineasOrdenTrabajos;
	}

}
