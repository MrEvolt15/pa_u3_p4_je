package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CtaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class CtaBancariaRepositoryImpl implements CtaBancariaRepository{
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void insertar(CtaBancaria cta) {
		this.entityManager.persist(cta);
		
	}

	@Override
	public void eliminar(Integer id) {
		CtaBancaria ctaEncontrado = this.seleccionarPorID(id);
		this.entityManager.remove(ctaEncontrado);
		
	}

	@Override
	public CtaBancaria seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CtaBancaria.class, id);
	}

	@Override
	public void actualizar(CtaBancaria cta) {
		this.entityManager.merge(cta);
		
	}

	@Override
	public CtaBancaria seleccionarPorNumero(String numero) {
		TypedQuery<CtaBancaria> myQuery = this.entityManager.createQuery("SELECT c FROM CtaBancaria c WHERE c.numero= :datoNumero", CtaBancaria.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

}
