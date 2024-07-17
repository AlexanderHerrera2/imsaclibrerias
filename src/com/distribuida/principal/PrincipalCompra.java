package com.distribuida.principal;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.CompraDAO;
import com.distribuida.entities.Compra;

public class PrincipalCompra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CompraDAO CompraDAO = context.getBean("compraDAOimpl",CompraDAO.class);
		
		//ProveedorDAO proveedorDAO = context.getBean("proveedorDAOimpl",ProveedorDAO.class);
		
		//SucursalDAO sucursalDAO = context.getBean("sucursalDAOimpl", SucursualDAO.class);
		
		//VendedorDAO vendedorDAO = context.getBean("vendedorDAO", VendedorDAO.class);
		
		// CRUD : CREATE, READ, UPDATE, DELETE
		//compra.setProveedor(proveedorDAO.findOne(1));
		// Add
		Compra Compra = new Compra(0,new Date(),3,3,3,105.36);
		//CompraDAO.add(Compra);
		//Compra.setProveedor(proveedorDAO.findOne(1));
		//Compra.setSucursal(sucursalDAO.findOne(1));
		//Compra.setVendedor(vendedorDAO.findOne(1));
		
		
		// Up
		Compra Compra2 = new Compra(2,new Date(),2,2,2,125.36);
		//CompraDAO.up(Compra2);
		
		// Delete
		//CompraDAO.dell(2);
		
		// findOne
		System.out.println("**************** DEL ****************"+CompraDAO.findOne(1));
		
		// findAll
		List<Compra> Compras = CompraDAO.findALL();
		
		Compras.forEach(item -> {
			System.out.println(item.toString());
		});
		
				context.close();
	}

}
