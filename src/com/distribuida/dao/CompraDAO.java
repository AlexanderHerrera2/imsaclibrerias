package com.distribuida.dao;

import java.util.List;

import com.distribuida.entities.Compra;

public interface CompraDAO {
	
public List<Compra> findALL();
	
	public Compra findOne(int id);
	
	public void add (Compra compra);
	
	public void up (Compra compra);
	
	public void dell (int id);
}