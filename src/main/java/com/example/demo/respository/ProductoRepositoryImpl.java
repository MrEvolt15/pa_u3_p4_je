package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
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
	public int eliminarPorNombre(String nombre) {
		Query miQuery = this.entityManager.createQuery("DELETE FROM Producto e Where e.nombre=:datoNombre");
		miQuery.setParameter("datoNombre", nombre);

		return miQuery.executeUpdate();
	}

	@Override
	public int actualizarPorNombreFecha(String nombre, LocalDate fechaC) {
		Query miQuery = this.entityManager.createQuery("UPDATE Producto e SET e.fechaCaducidad=:datoFecha WHERE e.nombre=:datoNombre");
		miQuery.setParameter("datoNombre",nombre);
		miQuery.setParameter("datoFecha", fechaC);
	    return	miQuery.executeUpdate();
	}

	

}
