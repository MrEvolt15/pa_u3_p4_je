package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.MateriaPrima;

import com.example.demo.repository.modelo.ProductoFinal;
import com.example.demo.respository.ProductoFinalRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
@Service
public class ProductoFinalServiceImpl implements ProductoFinalService{
	@Autowired
	private ProductoFinalRepository finalRepository;
	@Override
	public List<ProductoFinal> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.finalRepository.seleccionarInnerJoin();
	}

	@Override
	public List<ProductoFinal> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.finalRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<ProductoFinal> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.finalRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<MateriaPrima> buscarMateriaPrimaOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.finalRepository.seleccionarMateriaPrimaOuterLeftJoin();
	}

	@Override
	public List<ProductoFinal> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.finalRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<ProductoFinal> buscarJoinWhere() {
		// TODO Auto-generated method stub
		return this.finalRepository.seleccionarJoinWhere();
	}

	@Override
	public List<ProductoFinal> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.finalRepository.seleccionarFetchJoin();
	}
	

}
