package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional 
public class ProductoRepositoryImpl implements ProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);
	}

	@Override
	public void eliminar(Integer id) {
		Producto prodEncontrado = this.seleccionarPorID(id);
		this.entityManager.remove(prodEncontrado);
	}

	@Override
	public Producto seleccionarPorID(Integer id) {
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
		
	}

	@Override
	public Producto seleccionarPorFecha(Instant fecha) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Producto e WHERE e.fecha = :datoFecha");
		myQuery.setParameter("datoFecha", fecha);
		return (Producto) myQuery.getSingleResult();
	}

	@Override
	public List<Producto> seleccionarListaPorFecha(Instant fecha) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Producto e WHERE e.fecha = :datoFecha");
		myQuery.setParameter("datoFecha", fecha);
		return myQuery.getResultList();
	}

	@Override
	public Producto seleccionarPorPrecio(BigDecimal precio) {
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT e FROM Producto e WHERE e.precio = :datoPrecio", Producto.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Producto> seleccionarListaPorPrecio(BigDecimal precio) {
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT e FROM Producto e WHERE e.precio = :datoPrecio", Producto.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}


}
