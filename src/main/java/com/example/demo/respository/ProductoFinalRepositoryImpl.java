package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.MateriaPrima;

import com.example.demo.repository.modelo.ProductoFinal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional 
public class ProductoFinalRepositoryImpl implements ProductoFinalRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ProductoFinal> seleccionarInnerJoin() {
		TypedQuery<ProductoFinal> myQuery = this.entityManager.createQuery("SELECT pf FROM ProductoFinal pf JOIN pf.materiasPrimas mp",
				ProductoFinal.class);
		List<ProductoFinal> miLista = myQuery.getResultList();
		for (ProductoFinal c : miLista) {
			c.getMatirasPrimas().size();
		}
		return miLista;
	}

	@Override
	public List<ProductoFinal> seleccionarOuterRightJoin() {
		TypedQuery<ProductoFinal> myQuery = this.entityManager.createQuery("SELECT pf FROM ProductoFinal pf RIGHT JOIN pf.materiasPrimas mp",
				ProductoFinal.class);

		return myQuery.getResultList();
	}

	@Override
	public List<ProductoFinal> seleccionarOuterLeftJoin() {
		TypedQuery<ProductoFinal> myQuery = this.entityManager.createQuery("SELECT pf FROM ProductoFinal pf LEFT JOIN pf.materiasPrimas mp",
				ProductoFinal.class);

		return myQuery.getResultList();
	}

	@Override
	public List<MateriaPrima> seleccionarMateriaPrimaOuterLeftJoin() {
		TypedQuery<MateriaPrima> myQuery = this.entityManager
				.createQuery("SELECT mp FROM ProductoFinal pf LEFT JOIN pf.materiasPrimas mp", MateriaPrima.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<ProductoFinal> seleccionarOuterFullJoin() {
		TypedQuery<ProductoFinal> myQuery = this.entityManager.createQuery("SELECT pf FROM ProductoFinal pf FULL JOIN pf.materiasPrimas mp",
				ProductoFinal.class);

		return myQuery.getResultList();
	}

	@Override
	public List<ProductoFinal> seleccionarJoinWhere() {
		TypedQuery<ProductoFinal> myQuery = this.entityManager.createQuery("SELECT pf FROM ProductoFinal pf, MateriaPrima mp WHERE pf=mp.prodFinal ",
				ProductoFinal.class);

		return myQuery.getResultList();
	}

}
