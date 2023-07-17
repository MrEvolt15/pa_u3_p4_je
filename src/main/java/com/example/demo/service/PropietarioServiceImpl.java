package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Propietario;

import com.example.demo.respository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements PropietarioService{
	
	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Override
	public void guardar(Propietario prop) {
	this.propietarioRepository.insertar(prop);
	}

	@Override
	public void borrar(Integer id) {
		this.propietarioRepository.eliminar(id);
	}

	@Override
	public Propietario buscarPorID(Integer id) {
		
		return this.propietarioRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Propietario producto) {
		this.propietarioRepository.actualizar(producto);
	}



}
