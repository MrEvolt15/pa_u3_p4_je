package com.example.demo.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.respository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public void guardar(Producto producto) {
	this.productoRepository.insertar(producto);
	}

	@Override
	public void borrar(Integer id) {
		this.productoRepository.eliminar(id);
	}

	@Override
	public Producto buscarPorID(Integer id) {
		
		return this.productoRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Producto producto) {
		this.productoRepository.actualizar(producto);
	}

	@Override
	public Producto buscarPorFecha(Instant fecha) {
		// TODO Auto-generated method stub
		return this.productoRepository.seleccionarPorFecha(fecha);
	}

	@Override
	public List<Producto> buscarListaPorFecha(Instant fecha) {
		// TODO Auto-generated method stub
		return this.productoRepository.seleccionarListaPorFecha(fecha);
	}

	@Override
	public Producto buscarPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.productoRepository.seleccionarPorPrecio(precio);
	}

	@Override
	public List<Producto> buscarListaPorPrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.productoRepository.seleccionarListaPorPrecio(precio);
	}

}
