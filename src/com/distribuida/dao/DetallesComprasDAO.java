package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.DetallesCompras;

public interface DetallesComprasDAO {

public List <DetallesCompras> findALL();

	public DetallesCompras findOne(int id);
	
	public void add (DetallesCompras detallesCompras);
	
	public void up (DetallesCompras detallesCompras);
	
	public void dell (int id);
	
}
