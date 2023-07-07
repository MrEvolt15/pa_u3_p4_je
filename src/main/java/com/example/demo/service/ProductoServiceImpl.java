package com.example.demo.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
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
	public int borrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.productoRepository.eliminarPorNombre(nombre);
	}

	@Override
	public int actualizarPorNombreFecha(String nombre, LocalDate fechaC) {
		// TODO Auto-generated method stub
		return this.productoRepository.actualizarPorNombreFecha(nombre, fechaC);
	}


}
