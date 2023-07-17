package com.example.demo.respository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Producto;

public interface ClienteRepository {
	public void insertar(Cliente cliente);
	public void eliminar(Integer id);
	public Cliente seleccionarPorID(Integer id);
	public void actualizar(Cliente cliente);
	public Cliente seleccionarParaRifa(String nombre, BigDecimal precio);
	public List<Cliente> seleccionarInnerJoin();
	public List<Cliente> seleccionarOuterRightJoin();
	public List<Cliente> seleccionarOuterLeftJoin();
	public List<Producto> seleccionarProductoOuterLeftJoin();
	public List<Cliente> seleccionarOuterFullJoin();
	public List<Cliente> seleccionarJoinWhere();
	
	public List<Cliente> seleccionarFetchJoin();
	
}
