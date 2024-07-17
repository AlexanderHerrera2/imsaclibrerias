package com.distribuida.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table (name = "compras")
public class Compra {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_compra")
	private int idCompra;
	@Column (name = "FechaCompra")
	private Date fechaCompra;
	@Column (name = "IdProveedor")
	private int idProveedor;
	@Column (name = "IdSucursal")
	private int idSucursal;
	@Column (name = "IdVendedor")
	private int idVendedor;
	@Column (name = "Total")
	private double total;
	
	//@JoinColumn (name = "IdProveedor")
	//@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	//private Proveedor proveedor;
	
	/* @JoinColumn (name = "IdSucursal")
	 * @ManyToOne(cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 * private Sucursal sucursal;.*/

	/* @JoinColumn (name = "IdVendedor")
	 * @ManyToOne(cascade ={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	 * private Vendedor vendedor;.*/
	
	public Compra() {}
	
	public Compra(int idCompra, Date fechaCompra, int idProveedor, int idSucursal, int idVendedor, Double total) {
		this.idCompra = idCompra;
		this.fechaCompra = fechaCompra;
		this.idProveedor = idProveedor;
		this.idSucursal = idSucursal;
		this.idVendedor = idVendedor;
		this.total = total;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fechaCompra=" + fechaCompra + ", idProveedor=" + idProveedor
				+ ", idSucursal=" + idSucursal + ", idVendedor=" + idVendedor + ", total=" + total + "]";
	}
			
	
}
