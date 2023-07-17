package com.example.demo.respository;


import java.util.List;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.MateriaPrima;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoFinal;

public interface ProductoFinalRepository {
	
	public List<ProductoFinal> seleccionarInnerJoin();
	public List<ProductoFinal> seleccionarOuterRightJoin();
	public List<ProductoFinal> seleccionarOuterLeftJoin();
	public List<MateriaPrima> seleccionarMateriaPrimaOuterLeftJoin();
	public List<ProductoFinal> seleccionarOuterFullJoin();
	public List<ProductoFinal> seleccionarJoinWhere();
	
	public List<ProductoFinal> seleccionarFetchJoin();
}
