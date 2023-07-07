package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.Cliente;

public interface ClienteService {
	public void guardar(Cliente cliente);
	public void borrar(Integer id);
	public Cliente buscarPorID(Integer id);
	public void actualizar(Cliente cliente);
	public Cliente buscarParaRifa(String nombre, BigDecimal precio);

}
