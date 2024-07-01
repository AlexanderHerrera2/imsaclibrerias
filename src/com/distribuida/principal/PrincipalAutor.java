package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.AutorDAO;
import com.distribuida.entities.Autor;

public class PrincipalAutor{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

		AutorDAO autorDAO = context.getBean("autorDAOimpl",AutorDAO.class);
		
		// CRUD : CREATE, READ, UPDATE, DELETE
		
		// Add
		/*Autor autor = new Autor(0,"juan","taipe","pais","av. por ahi...", "0987654321","jtaipe@correo.com");
		autorDAO.add(autor);*/
		
		// Up
		Autor autor2 = new Autor(56,"juan2","taipe2","pais2","av. por ahi...2", "09876543212","jtaipe@correo.com2");
		autorDAO.up(autor2);
		
		// Delete
		//autorDAO.dell(39);
		
		// findOne
		//System.out.println("**************** DEL ****************"+autorDAO.findOne(1));
		
		// findAll
		List<Autor> Autor = autorDAO.findALL();
		
		Autor.forEach(item -> {
			System.out.println(item.toString());
		});
		
				context.close();
	}

}
