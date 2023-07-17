package com.example.demo.service;


import java.util.List;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.MateriaPrima;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoFinal;

public interface ProductoFinalService {
	
	public List<ProductoFinal> buscarInnerJoin();
	public List<ProductoFinal> buscarOuterRightJoin();
	public List<ProductoFinal> buscarOuterLeftJoin();
	public List<MateriaPrima> buscarMateriaPrimaOuterLeftJoin();
	public List<ProductoFinal> buscarOuterFullJoin();
	public List<ProductoFinal> buscarJoinWhere();
	
	public List<ProductoFinal> buscarFetchJoin();
}
