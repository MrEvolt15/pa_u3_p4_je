package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.mapping.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.funcional.Main;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Factura;
import com.example.demo.repository.modelo.Persona;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.FacturaService;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.IPruebaService;
import com.example.demo.service.ITransferenciaService;
import com.example.demo.service.PersonaService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P4TareaNsApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4TareaNsApplication.class);

	@Autowired
	private ICuentaBancariaService bancariaService;

	@Autowired
	private PersonaService personaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4TareaNsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//                     ASINCRONO FUTURO CON RESPUESTA
		
		// Imprime el nombre del hilo con el que se ejecuta mi propgrama
		LOG.info("Hilo principal: " + Thread.currentThread().getName());

		long tiempoInicial = System.currentTimeMillis();
		
		
		List<CompletableFuture<Integer>> listaRespuestas= new ArrayList<>();
		Double promedio =0.0;
		for (int i = 1; i <= 3; i++) {
			
			CompletableFuture<Integer> respuesta=this.personaService.consultaPorIdAsincrono(i); // Una promesa que se va a completar en el Futuro
			listaRespuestas.add(respuesta);
			
		}
		
		//Senterncia que espera que termine de procesarse todos los hilos para obtener la respuesta
		CompletableFuture.allOf(listaRespuestas.get(0),listaRespuestas.get(1),listaRespuestas.get(2));
		promedio += (listaRespuestas.get(0).get()+listaRespuestas.get(1).get()+listaRespuestas.get(2).get());
		
		LOG.info("Promedio de edades: " + promedio/3);
		//LOG.info("Respuesta 0:"+ listaRespuestas.get(0).get());
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + tiempoTranscurrido);
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));

		LOG.info("Se termino de procesar todo ");

	}

}