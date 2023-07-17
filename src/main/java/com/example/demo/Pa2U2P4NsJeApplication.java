package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.MateriaPrima;
import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.ProductoFinal;
import com.example.demo.service.ClienteService;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.ProductoFinalService;
import com.example.demo.service.ProductoService;


@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProductoFinalService finalService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		List<Cliente> clientes1 =this.clienteService.buscarJoinWhere();
		for(Cliente e: clientes1) {
			System.out.println(e);
		}
		List<Cliente> clientes2 =this.clienteService.buscarOuterFullJoin();
		for(Cliente e: clientes2) {
			System.out.println(e);
		}
		List<Cliente> clientes3 =this.clienteService.buscarOuterLeftJoin();
		for(Cliente e: clientes3) {
			System.out.println(e);
		}
		List<Cliente> clientes4 =this.clienteService.buscarOuterRightJoin();
		for(Cliente e: clientes4) {
			System.out.println(e);
		}
		List<Producto> productos1 =this.clienteService.buscarProductoOuterLeftJoin();
		for(Producto e: productos1) {
			System.out.println(e);
		}
		List<Cliente> clientes5 = this.clienteService.buscarInnerJoin();
		for(Cliente e: clientes5) {
			System.out.println(e);
		}
		
		List<ProductoFinal> pf1 =this.finalService.buscarJoinWhere();
		for(ProductoFinal e: pf1) {
			System.out.println(e);
		}
		List<MateriaPrima> pf2 =this.finalService.buscarMateriaPrimaOuterLeftJoin();
		for(MateriaPrima e: pf2) {
			System.out.println(e);
		}
		List<ProductoFinal> pf3 =this.finalService.buscarOuterFullJoin();
		for(ProductoFinal e: pf3) {
			System.out.println(e);
		}
		List<ProductoFinal> pf4 =this.finalService.buscarOuterLeftJoin();
		for(ProductoFinal e: pf4) {
			System.out.println(e);
		}
		List<ProductoFinal> pf5 =this.finalService.buscarOuterRightJoin();
		for(ProductoFinal e: pf5) {
			System.out.println(e);
		}
		List<ProductoFinal> pf6 =this.finalService.buscarInnerJoin();
		for(ProductoFinal e: pf6) {
			System.out.println(e);
		}
	}

}