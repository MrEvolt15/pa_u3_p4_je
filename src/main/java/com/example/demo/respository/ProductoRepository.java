package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import com.example.demo.repository.modelo.Producto;



public interface ProductoRepository {
	public void insertar(Producto producto);
	public void eliminar(Integer id);
	public Producto seleccionarPorID(Integer id);
	public void actualizar(Producto producto);
	// queries especificas
	public Producto seleccionarPorFecha(Instant fecha);
	public List<Producto> seleccionarListaPorFecha(Instant fecha);
	
	public Producto seleccionarPorPrecio(BigDecimal precio);
	public List<Producto> seleccionarListaPorPrecio(BigDecimal precio);
}
