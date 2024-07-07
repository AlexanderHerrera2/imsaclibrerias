package com.distribuida.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name = "detallescompras")
public class DetallesCompras {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id_detalle_compra")
	private int idDetalleCompra;
	@Column (name="idCompra")
	private int idCompra;
	@Column (name="idProducto")
	private int idProducto;
	@Column (name="Cantidad")
	private int cantidad;
	@Column (name="PrecioUnitario")
	private double precioUnitario;
	
	public DetallesCompras() {}
	
	public DetallesCompras(int idDetalleCompra, int idCompra, int idProducto, int cantidad, double precioUnitario) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "DetallesCompras [idDetalleCompra=" + idDetalleCompra + ", idCompra=" + idCompra + ", idProducto="
				+ idProducto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + "]";
	}
	
	
	
}
