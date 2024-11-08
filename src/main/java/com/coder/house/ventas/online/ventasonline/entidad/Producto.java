package com.coder.house.ventas.online.ventasonline.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productoid;

	private String nombre;

	private Integer cantidad;

	private Integer codigo;

	private String descripcion;

	private BigDecimal precio;

	private String categoria;

	private String imagenUrl;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	private boolean estado;

	public Producto() {
		this.fechaCreacion = new Date();
		this.estado = true;
	}

	// Getters y Setters

	public Integer getProductoid() {
		return this.productoid;
	}

	public void setProductoid(Integer productoid) {
		this.productoid = productoid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Producto [");
		if (productoid != null)
			builder.append("productoid=").append(productoid).append(", ");
		if (nombre != null)
			builder.append("nombre=").append(nombre).append(", ");
		if (cantidad != null)
			builder.append("cantidad=").append(cantidad).append(", ");
		if (codigo != null)
			builder.append("codigo=").append(codigo).append(", ");
		if (descripcion != null)
			builder.append("descripcion=").append(descripcion).append(", ");
		if (precio != null)
			builder.append("precio=").append(precio).append(", ");
		if (categoria != null)
			builder.append("categoria=").append(categoria).append(", ");
		if (imagenUrl != null)
			builder.append("imagenUrl=").append(imagenUrl).append(", ");
		if (fechaCreacion != null)
			builder.append("fechaCreacion=").append(fechaCreacion).append(", ");
		builder.append("estado=").append(estado);
		builder.append("]");
		return builder.toString();
	}
}