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
 * OrdenesEntrada generated by hbm2java
 */
@Entity
@Table(name = "Ordenes_Entrada", schema = "demo", catalog = "esbTactic", uniqueConstraints = @UniqueConstraint(columnNames = "Identificador") )
public class OrdenesEntrada implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private CausalesAnulacionOrdenEntrada causalesAnulacionOrdenEntrada;
	private EstadosOrdenEntrada estadosOrdenEntrada;
	private String identificador;
	private char idTipoTransaccion;
	private String idCliente;
	private String idPais;
	private String idCiudad;
	private String idBodega;
	private String numeroOrdenEntrada;
	private String idTipoOrdenEntrada;
	private String idProveedor;
	private Date fechaModificacion;
	private String usuarioModificacion;
	private Set<LineasOrdenEntrada> lineasOrdenEntradas = new HashSet<LineasOrdenEntrada>(0);

	public OrdenesEntrada() {
	}

	public OrdenesEntrada(Integer id, EstadosOrdenEntrada estadosOrdenEntrada, String identificador,
			char idTipoTransaccion, String idCliente, String numeroOrdenEntrada,
			String idTipoOrdenEntrada, Date fechaModificacion, String usuarioModificacion) {
		this.id = id;
		this.estadosOrdenEntrada = estadosOrdenEntrada;
		this.identificador = identificador;
		this.idTipoTransaccion = idTipoTransaccion;
		this.idCliente = idCliente;
		this.numeroOrdenEntrada = numeroOrdenEntrada;
		this.idTipoOrdenEntrada = idTipoOrdenEntrada;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
	}

	public OrdenesEntrada(Integer id, CausalesAnulacionOrdenEntrada causalesAnulacionOrdenEntrada,
			EstadosOrdenEntrada estadosOrdenEntrada, String identificador, char idTipoTransaccion,
			String idCliente, String idPais, String idCiudad, String idBodega,
			String numeroOrdenEntrada, String idTipoOrdenEntrada, String idProveedor,
			Date fechaModificacion, String usuarioModificacion, Set<LineasOrdenEntrada> lineasOrdenEntradas) {
		this.id = id;
		this.causalesAnulacionOrdenEntrada = causalesAnulacionOrdenEntrada;
		this.estadosOrdenEntrada = estadosOrdenEntrada;
		this.identificador = identificador;
		this.idTipoTransaccion = idTipoTransaccion;
		this.idCliente = idCliente;
		this.idPais = idPais;
		this.idCiudad = idCiudad;
		this.idBodega = idBodega;
		this.numeroOrdenEntrada = numeroOrdenEntrada;
		this.idTipoOrdenEntrada = idTipoOrdenEntrada;
		this.idProveedor = idProveedor;
		this.fechaModificacion = fechaModificacion;
		this.usuarioModificacion = usuarioModificacion;
		this.lineasOrdenEntradas = lineasOrdenEntradas;
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
	@JoinColumn(name = "Id_Causal_Anulacion_Orden_Entrada")
	public CausalesAnulacionOrdenEntrada getCausalesAnulacionOrdenEntrada() {
		return this.causalesAnulacionOrdenEntrada;
	}

	public void setCausalesAnulacionOrdenEntrada(CausalesAnulacionOrdenEntrada causalesAnulacionOrdenEntrada) {
		this.causalesAnulacionOrdenEntrada = causalesAnulacionOrdenEntrada;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Id_Estado_Orden_Entrada", nullable = false)
	public EstadosOrdenEntrada getEstadosOrdenEntrada() {
		return this.estadosOrdenEntrada;
	}

	public void setEstadosOrdenEntrada(EstadosOrdenEntrada estadosOrdenEntrada) {
		this.estadosOrdenEntrada = estadosOrdenEntrada;
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

	@Column(name = "Numero_Orden_Entrada", nullable = false)
	public String getNumeroOrdenEntrada() {
		return this.numeroOrdenEntrada;
	}

	public void setNumeroOrdenEntrada(String numeroOrdenEntrada) {
		this.numeroOrdenEntrada = numeroOrdenEntrada;
	}

	@Column(name = "Id_Tipo_Orden_Entrada", nullable = false)
	public String getIdTipoOrdenEntrada() {
		return this.idTipoOrdenEntrada;
	}

	public void setIdTipoOrdenEntrada(String idTipoOrdenEntrada) {
		this.idTipoOrdenEntrada = idTipoOrdenEntrada;
	}

	@Column(name = "Id_Proveedor")
	public String getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordenesEntrada")
	public Set<LineasOrdenEntrada> getLineasOrdenEntradas() {
		return this.lineasOrdenEntradas;
	}

	public void setLineasOrdenEntradas(Set<LineasOrdenEntrada> lineasOrdenEntradas) {
		this.lineasOrdenEntradas = lineasOrdenEntradas;
	}

}
