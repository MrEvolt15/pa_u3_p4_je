package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class TransferenciaRepositoryImpl implements TransferenciaRepository{
	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void insertar(Transferencia trans) {
		this.entityManager.persist(trans);
		
	}

	@Override
	public void eliminar(Integer id) {
		Transferencia ctaEncontrado = this.seleccionarPorID(id);
		this.entityManager.remove(ctaEncontrado);
		
	}

	@Override
	public Transferencia seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	public void actualizar(Transferencia trans) {
		this.entityManager.merge(trans);
		
	}

	@Override
	public List<Transferencia> listaTodo() {
		//RIGHT JOIN c.productos p
			TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("SELECT t FROM Transferencia t ",
					Transferencia.class);

			return myQuery.getResultList();
		
	}

}
