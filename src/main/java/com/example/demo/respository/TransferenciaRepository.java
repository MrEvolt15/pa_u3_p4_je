package com.example.demo.respository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface TransferenciaRepository {
	
	public void insertar(Transferencia trans);
	public void eliminar(Integer id);
	public Transferencia seleccionarPorID(Integer id);
	public void actualizar(Transferencia trans);
	public List<Transferencia> listaTodo();
}
