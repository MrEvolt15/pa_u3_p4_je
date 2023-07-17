package com.example.demo.service;


import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.Transferencia;

public interface TransferenciaService {
	public void guardar(Transferencia trans);
	public void borrar(Integer id);
	public Transferencia buscarPorID(Integer id);
	public void actualizar(Transferencia trans);
	//realizar transferencia
	public void realizarTransferencia(String ctaOrigen,String ctaDestino, BigDecimal monto);
	//enlistar todas las transferencias
	public List<Transferencia> reporteTransferencias();
	
	
}
