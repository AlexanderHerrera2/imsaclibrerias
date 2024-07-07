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
		
		// CRUD : CREATE, READ, UPDATE, DELETE
		
		// Add
		Compra Compra = new Compra(0,new Date(),1,1,1,105.36);
		//CompraDAO.add(Compra);
		
		// Up
		Compra Compra2 = new Compra(2,new Date(),2,2,2,125.36);
		//CompraDAO.up(Compra2);
		
		// Delete
		CompraDAO.dell(2);
		
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
