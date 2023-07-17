package com.example.demo.service;

import java.math.BigDecimal;

import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Propietario;


public interface CtaBancariaService {
	public void guardar(CtaBancaria cta);
	public void borrar(Integer id);
	public CtaBancaria buscarPorID(Integer id);
	public void actualizardeff(CtaBancaria cta);
	
	public CtaBancaria consultarPorId(Integer id);
	public void actualizar(CtaBancaria cta);

}
