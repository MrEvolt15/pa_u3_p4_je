package com.example.demo.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoService {
	public void guardar(Producto producto);
	public void borrar(Integer id);
	public Producto buscarPorID(Integer id);
	public void actualizar(Producto producto);
	// Actualizar y Borrar

	
	public int borrarPorNombre(String nombre);

	public int actualizarPorNombreFecha(String nombre,LocalDate fechaC);
}
