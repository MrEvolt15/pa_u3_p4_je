package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Producto;


public interface ClienteService {
	public void guardar(Cliente cliente);
	public void borrar(Integer id);
	public Cliente buscarPorID(Integer id);
	public void actualizar(Cliente cliente);
	public Cliente buscarParaRifa(String nombre, BigDecimal precio);
	public List<Cliente> buscarInnerJoin();
	public List<Cliente> buscarOuterRightJoin();
	public List<Cliente> buscarOuterLeftJoin();
	public List<Producto> buscarProductoOuterLeftJoin();
	public List<Cliente> buscarOuterFullJoin();
	public List<Cliente> buscarJoinWhere();
	
	public List<Cliente> buscarFetchJoin();
}
