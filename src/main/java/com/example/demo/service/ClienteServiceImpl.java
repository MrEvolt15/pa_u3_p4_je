package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoFinal;
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

	@Override
	public List<Cliente> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Cliente> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Producto> buscarProductoOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarProductoOuterLeftJoin();
	}

	@Override
	public List<Cliente> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Cliente> buscarJoinWhere() {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarJoinWhere();
	}

	@Override
	public List<Cliente> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Cliente> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.clienteRepository.seleccionarFetchJoin();
	}

}
