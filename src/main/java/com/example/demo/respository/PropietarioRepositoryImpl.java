package com.example.demo.respository;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class PropietarioRepositoryImpl implements PropietarioRepository{
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void insertar(Propietario prop) {
		this.entityManager.persist(prop);
		
	}

	@Override
	public void eliminar(Integer id) {
		Propietario ctaEncontrado = this.seleccionarPorID(id);
		this.entityManager.remove(ctaEncontrado);
		
	}

	@Override
	public Propietario seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public void actualizar(Propietario prop) {
		this.entityManager.merge(prop);
		
	}

}
