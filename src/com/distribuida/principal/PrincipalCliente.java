package com.distribuida.principal;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.dao.ClienteDAO;
import com.distribuida.entities.Cliente;

public class PrincipalCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		ClienteDAO clienteDAO = context.getBean("clienteDAOimpl",ClienteDAO.class);
		
		// CRUD : CREATE, READ, UPDATE, DELETE
		
		// Add
		Cliente cliente = new Cliente(0,"123456789","juan","taipe","av. por ahi...", "0987654321");
		clienteDAO.add(cliente);
		
		// Up
		Cliente cliente2 = new Cliente(39,"123456789","juan2","taipe2","av. por ahi...2", "09876543212");
		clienteDAO.up(cliente2);
		
		// Delete
		clienteDAO.dell(39);
		
		// findOne
		System.out.println("**************** DEL ****************"+clienteDAO.findOne(1));
		
		// findAll
		List<Cliente> clientes = clienteDAO.findALL();
		
		clientes.forEach(item -> {
			System.out.println(item.toString());
		});
		
				context.close();
	}
}
