package com.example.demo.respository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
@Repository
@Transactional 
public class ClienteRepositoryImpl implements ClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		Cliente cliEncontrado = this.seleccionarPorID(id);
		this.entityManager.remove(cliEncontrado);
	}

	@Override
	public Cliente seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente seleccionarParaRifa(String nombre, BigDecimal precio) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> myCriteriAQuery= myBuilder.createQuery(Cliente.class);
		Root<Cliente> miTablaFrom = myCriteriAQuery.from(Cliente.class);
		
		Predicate pNombre= myBuilder.equal(miTablaFrom.get("nomCli"), nombre);

		Predicate pCedula=myBuilder.like(miTablaFrom.get("cedula"),"%2%");

		Predicate predicadoFinal=null;
		if(precio.compareTo(BigDecimal.valueOf(2.00))>=2.00) {
			predicadoFinal= myBuilder.or(pNombre,pCedula);
			System.out.println("compras mayores a 2.00");
		}else {
			predicadoFinal = myBuilder.and(pNombre,pCedula);
			System.out.println("compras menores a 2.00, hay un 2 en la cedula?");
		}
		myCriteriAQuery.select(miTablaFrom).where(predicadoFinal);

		TypedQuery<Cliente> myQueryFinal = this.entityManager.createQuery(myCriteriAQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public List<Cliente> seleccionarOuterRightJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c RIGHT JOIN c.productos p",
				Cliente.class);

		return myQuery.getResultList();
	}
	

	@Override
	public List<Cliente> seleccionarOuterLeftJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c LEFT JOIN c.productos p",
				Cliente.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Producto> seleccionarProductoOuterLeftJoin() {
		TypedQuery<Producto> myQuery = this.entityManager
				.createQuery("SELECT p FROM Cliente c LEFT JOIN c.productos p", Producto.class);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarOuterFullJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c FULL JOIN c.productos p",
				Cliente.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarJoinWhere() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c, Producto p WHERE c=p.cliente ",
				Cliente.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarInnerJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c JOIN c.productos p",
				Cliente.class);
		List<Cliente> miLista = myQuery.getResultList();
		for (Cliente c : miLista) {
			c.getProductos().size();
		}
		return miLista;
	}

}
