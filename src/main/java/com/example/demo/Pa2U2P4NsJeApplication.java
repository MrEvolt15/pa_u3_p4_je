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
import com.example.demo.repository.modelo.Producto;
import com.example.demo.service.ClienteService;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.ProductoService;


@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProductoService productoService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto p1 = new Producto();
		p1.setFechaCaducidad(LocalDate.of(2023, 10, 20));
		p1.setNombre("Ruflex 530g");
		p1.setPrecio(BigDecimal.valueOf(1.20));
		p1.setTipo("Snacks");
		
		Producto p2 = new Producto();
		p2.setFechaCaducidad(LocalDate.of(2023, 12, 12));
		p2.setNombre("Chifles 320g");
		p2.setPrecio(BigDecimal.valueOf(0.99));
		p2.setTipo("Snacks");
		
		Producto p3 = new Producto();
		p3.setFechaCaducidad(LocalDate.of(2023, 11, 14));
		p3.setNombre("Granola VItalty 400g");
		p3.setPrecio(BigDecimal.valueOf(2.00));
		p3.setTipo("Artesanales");
		
		List<Producto> carrito1 = new ArrayList<>();
		carrito1.add(p1);
		carrito1.add(p2);
		
		List<Producto> carrito2 = new ArrayList<>();
		carrito2.add(p3);
		
		Cliente c1 = new Cliente();
		c1.setCedula("1726333196");
		c1.setGenero("masculino");
		c1.setNomCli("Joel");
		c1.setProductos(carrito2);
		p3.setCliente(c1);
		
		Cliente c2 = new Cliente();
		c2.setCedula("1726333188");
		c2.setGenero("femenino");
		c2.setNomCli("Daniela");
		c2.setProductos(carrito1);
		p1.setCliente(c2);
		p2.setCliente(c2);
		
		//this.clienteService.guardar(c2);
		//this.clienteService.guardar(c1);
		//this.clienteService.buscarParaRifa("Joel", carrito2.get(0).getPrecio());
		this.productoService.actualizarPorNombreFecha("Granola VItalty 400g",LocalDate.of(2024, 2, 15));
		this.productoService.borrarPorNombre("Ruflex 530g");
		
	}

}