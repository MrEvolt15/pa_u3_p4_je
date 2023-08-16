package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.repository.PersonaRepository;
import com.example.demo.repository.modelo.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;
	private static final Logger LOG = LoggerFactory.getLogger(PersonaServiceImpl.class);

	
	@Override
	public void guardar(Persona persona) {
		this.personaRepository.insertar(persona);
		
	}

	@Override
	public void borrar(Integer id) {
		this.personaRepository.eliminar(id);
		
	}

	@Override
	@Async
	public Persona buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.personaRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub
		this.personaRepository.actualizar(persona);
	}

	@Override
	@Async
	public CompletableFuture<Integer> consultaPorIdAsincrono(Integer id) {
		LOG.info("Hilo Service. " + Thread.currentThread().getName());
		// Sumar restar ,ultiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer edad=this.personaRepository.seleccionarPorID(id).getEdad();
		return CompletableFuture.completedFuture(edad) ;
	}


}
