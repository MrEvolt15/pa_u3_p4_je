package com.example.demo.service;

import java.math.BigDecimal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.CtaBancaria;

import com.example.demo.respository.CtaBancariaRepository;

@Service
public class CtaBancariaServiceImpl implements CtaBancariaService {

	@Autowired
	private CtaBancariaRepository bancariaRepository;
	
	@Autowired
	@Qualifier("par")
	AbonoService abonoService;
	
	@Autowired
	@Qualifier("impar")
	AbonoService abonoService2;
	
	@Override
	public CtaBancaria consultarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(CtaBancaria cta) {
		this.bancariaRepository.actualizar(cta);
		
	}

	@Override
	public void guardar(CtaBancaria cta) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(cta);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CtaBancaria buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizardeff(CtaBancaria cta) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cta);
	}

	

}
