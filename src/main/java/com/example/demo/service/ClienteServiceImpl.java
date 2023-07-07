package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.respository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void guardar(Cliente cliente) {
		this.clienteRepository.insertar(cliente);
	}

	@Override
	public void borrar(Integer id) {
		this.clienteRepository.eliminar(id);
	}

	@Override
	public Cliente buscarPorID(Integer id) {
		
		return this.clienteRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
	}

	@Override
	public Cliente buscarParaRifa(String nombre, BigDecimal precio) {
		
		return this.clienteRepository.seleccionarParaRifa(nombre, precio);
	}

}
