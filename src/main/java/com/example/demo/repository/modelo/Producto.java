package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Producto {
	
	
	
	@GeneratedValue(generator = "seq_producto",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_producto",sequenceName ="seq_producto",allocationSize = 1 )
	@Id
	@Column(name = "prod_id")
	private Integer id;
	@Column(name = "prod_nombre")
	private String nombre;
	@Column(name = "prod_tipo")
	private String tipo;
	@Column(name = "prod_fecha_caducidad")
	private LocalDate fechaCaducidad;
	@Column(name = "prod_precio")
	private BigDecimal precio;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_id_cliete")
	private Cliente cliente; 
	
	//SET Y GET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fecha) {
		this.fechaCaducidad = fecha;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", fecha=" + fechaCaducidad + ", precio=" + precio + ", cliente="
				+ cliente + "]";
	}
	
	
	
}
