package com.example.demo.respository;

import com.example.demo.repository.modelo.Propietario;

public interface PropietarioRepository {
	
	public void insertar(Propietario prop);
	public void eliminar(Integer id);
	public Propietario seleccionarPorID(Integer id);
	public void actualizar(Propietario prop);

}
