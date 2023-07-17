package com.example.demo.service;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.respository.CtaBancariaRepository;
import com.example.demo.respository.TransferenciaRepository;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	private CtaBancariaRepository bancariaRepository;
	
	@Override
	public void guardar(Transferencia trans) {
	this.transferenciaRepository.insertar(trans);
	}

	@Override
	public void borrar(Integer id) {
		this.transferenciaRepository.eliminar(id);
	}

	@Override
	public Transferencia buscarPorID(Integer id) {
		
		return this.transferenciaRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Transferencia trans) {
		this.transferenciaRepository.actualizar(trans);
	}

	@Override
	public void realizarTransferencia(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		CtaBancaria ctaOrigens = this.bancariaRepository.seleccionarPorNumero(ctaOrigen);
		
		CtaBancaria ctaDestinos = this.bancariaRepository.seleccionarPorNumero(ctaDestino);
		Transferencia trans1 = new Transferencia();
		trans1.setCtaDestino(ctaDestinos);
		trans1.setCtaOrigen(ctaOrigens);
		trans1.setFecha(LocalDate.now());
		trans1.setMonto(monto);
		List<Transferencia> echas= new ArrayList<>();
		echas.add(trans1);
		if(ctaOrigens.getSaldo().compareTo(monto)==0 || ctaOrigens.getSaldo().compareTo(monto)==1 ) {
			ctaOrigens.setSaldo(ctaOrigens.getSaldo().subtract(monto));
			ctaDestinos.setSaldo(ctaDestinos.getSaldo().add(monto));
			this.bancariaRepository.actualizar(ctaDestinos);
			this.bancariaRepository.actualizar(ctaOrigens);
			this.transferenciaRepository.insertar(trans1);
		}else {
			System.out.println("La cuenta no tiene saldo suficiente!!!");
		}
		ctaOrigens.setTransferenciasPerformed(echas);
		ctaDestinos.setTransferenciaRecived(echas);
		
	}

	@Override
	public List<Transferencia> reporteTransferencias() {
	
		return this.transferenciaRepository.listaTodo();
	}



}
