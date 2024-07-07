package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.DetallesCompras;

@Repository
public class DetallesComprasDAOimpl implements DetallesComprasDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DetallesCompras> findALL() {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DetallesCompras", DetallesCompras.class).getResultList();
	}

	@Override
	@Transactional
	public DetallesCompras findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(DetallesCompras.class,id);
	}

	@Override
	@Transactional
	public void add(DetallesCompras detallesCompras) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(detallesCompras);
	}

	@Override
	@Transactional
	public void up(DetallesCompras detallesCompras) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		session.saveOrUpdate(detallesCompras);
		
	}

	@Override
	@Transactional
	public void dell(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		session.delete(findOne(id));
		
	}
}
