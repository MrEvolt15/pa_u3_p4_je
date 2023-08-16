package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.Persona;

public interface PersonaService {
	public void guardar(Persona persona);
	public void borrar(Integer id);
	public Persona buscarPorID(Integer id);
	public void actualizar(Persona persona);
	public CompletableFuture<Integer> consultaPorIdAsincrono(Integer id);
	
	
}
