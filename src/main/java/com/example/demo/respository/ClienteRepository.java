package com.example.demo.respository;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.Cliente;

public interface ClienteRepository {
	public void insertar(Cliente cliente);
	public void eliminar(Integer id);
	public Cliente seleccionarPorID(Integer id);
	public void actualizar(Cliente cliente);
	public Cliente seleccionarParaRifa(String nombre, BigDecimal precio);
	
	
}
