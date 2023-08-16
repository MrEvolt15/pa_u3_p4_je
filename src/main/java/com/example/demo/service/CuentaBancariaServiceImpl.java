package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.funcional.Main;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo Service. " + Thread.currentThread().getName());
		// Sumar restar ,ultiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(cuentaBancaria);
		
	}
	@Override
	public String guardar2(CuentaBancaria cuentaBancaria) {
	
		
		LOG.info("Hilo Service. " + Thread.currentThread().getName());
		// Sumar restar ,ultiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(cuentaBancaria);
		return cuentaBancaria.getNumero();
	}
	@Override
	public void borrar(Integer id) {
		this.bancariaRepository.eliminar(id);
		
	}
	@Override
	@Async
	public void guardarAsincrono(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		LOG.info("Hilo Service. " + Thread.currentThread().getName());
		// Sumar restar ,ultiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(cuentaBancaria);
		
	}
	@Override
	@Async
	public CompletableFuture<String> guardarAsincrono2(CuentaBancaria cuentaBancaria) {
		
		LOG.info("Hilo Service. " + Thread.currentThread().getName());
		// Sumar restar ,ultiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(cuentaBancaria);
		
		return CompletableFuture.completedFuture(cuentaBancaria.getNumero());
	}


	@Override
	public CuentaBancaria buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.actualizar(cuentaBancaria);
		
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numeroCuenta) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorNumero(numeroCuenta);
	}
	
}
