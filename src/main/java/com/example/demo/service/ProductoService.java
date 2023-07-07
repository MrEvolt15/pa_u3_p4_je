package com.example.demo.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoService {
	public void guardar(Producto producto);
	public void borrar(Integer id);
	public Producto buscarPorID(Integer id);
	public void actualizar(Producto producto);
	// queries especificas
	public Producto buscarPorFecha(Instant fecha);
	public List<Producto> buscarListaPorFecha(Instant fecha);
	
	public Producto buscarPorPrecio(BigDecimal precio);
	public List<Producto> buscarListaPorPrecio(BigDecimal precio);
}
