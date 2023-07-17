package com.example.demo.service;


import com.example.demo.repository.modelo.Propietario;

public interface PropietarioService {
	public void guardar(Propietario producto);
	public void borrar(Integer id);
	public Propietario buscarPorID(Integer id);
	public void actualizar(Propietario producto);
	// Actualizar y Borrar

	
}
