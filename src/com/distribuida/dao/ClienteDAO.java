package com.distribuida.dao;

import com.distribuida.entities.Cliente;
import java.util.List;

public interface ClienteDAO {

public List<Cliente> findALL();
	
	public Cliente findOne(int id);
	
	public void add (Cliente cliente);
	
	public void up (Cliente cliente);
	
	public void dell (int id);
}
