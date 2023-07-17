package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CtaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.CtaBancariaService;
import com.example.demo.service.PropietarioService;
import com.example.demo.service.TransferenciaService;


@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {
	@Autowired
	private PropietarioService propietarioService;
	@Autowired
	private TransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Propietario prop1 = new Propietario();
		prop1.setNombre("Joel");
		prop1.setApellido("Espinosa");
		prop1.setCedula("1726333196");
		
		Propietario prop2 = new Propietario();
		prop2.setNombre("Daniela");
		prop2.setApellido("Espinosa");
		prop2.setCedula("1726333188");
		
		CtaBancaria cta1 = new CtaBancaria();
		cta1.setNumero("13487492324a");
		cta1.setPropietario(prop1);
		cta1.setSaldo(BigDecimal.valueOf(200.00));
		cta1.setTipo("A");
		cta1.setPropietario(prop1);
		List<CtaBancaria> cuentasJoel = new ArrayList<>();
		cuentasJoel.add(cta1);
		
		CtaBancaria cta2 = new CtaBancaria();
		cta2.setNumero("261889813c");
		cta2.setPropietario(prop2);
		cta2.setSaldo(BigDecimal.valueOf(150.75));
		cta2.setTipo("C");
		cta2.setPropietario(prop2);
		List<CtaBancaria> cuentasDaniela = new ArrayList<>();
		cuentasDaniela.add(cta2);
		
		prop1.setCuentas(cuentasJoel);
		prop2.setCuentas(cuentasDaniela);
		
		//this.propietarioService.guardar(prop1);
		//this.propietarioService.guardar(prop2);
		this.transferenciaService.realizarTransferencia("13487492324a", "261889813c", BigDecimal.valueOf(175.00));
		
	}

}