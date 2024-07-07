package com.distribuida.principal;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.DetallesComprasDAO;
import com.distribuida.entities.DetallesCompras;

public class PrincipalDetallesCompras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		DetallesComprasDAO DetallesComprasDAO = context.getBean("detallesComprasDAOimpl",DetallesComprasDAO.class);
		
		// CRUD : CREATE, READ, UPDATE, DELETE
		
		// Add
		DetallesCompras DetallesCompras = new DetallesCompras(0,1,1,1,10.5);
		//DetallesComprasDAO.add(DetallesCompras);
		
		// Up
		DetallesCompras DetallesCompras2 = new DetallesCompras(1,2,2,2,30.2);
		//DetallesComprasDAO.up(DetallesCompras2);
		
		// Delete
		DetallesComprasDAO.dell(1);
		
		// findOne
		System.out.println("**************** DEL ****************"+DetallesComprasDAO.findOne(1));
		
		// findAll
		List<DetallesCompras> DetallesComprass = DetallesComprasDAO.findALL();
		
		DetallesComprass.forEach(item -> {
			System.out.println(item.toString());
		});
		
				context.close();
	}

}
