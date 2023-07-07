package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import com.example.demo.repository.modelo.Producto;



public interface ProductoRepository {
	public void insertar(Producto producto);
	public void eliminar(Integer id);
	public Producto seleccionarPorID(Integer id);
	public void actualizar(Producto producto);
	// Actualizar y Eliminar
	
	
	public int eliminarPorNombre(String nombre);

	public int actualizarPorNombreFecha(String nombre,LocalDate fechaC);
}
