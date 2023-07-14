package com.example.demo.repository.modelo;

import java.math.BigDecimal;
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
public class MateriaPrima {

	@GeneratedValue(generator = "seq_materia_prima",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_materia_prima",sequenceName ="seq_materia_prima",allocationSize = 1 )
	@Id
	@Column(name = "matP_id")
	private Integer id;
	@Column(name = "matP_nombre")
	private String nombre;
	@Column(name = "matP_tipo")
	private String tipo;
	@Column(name = "matP_fecha_caducidad")
	private LocalDate fechaCaducidad;
	@Column(name = "matP_precio")
	private BigDecimal precio;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matP_id_prof")
	private ProductoFinal prodFinal;

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


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}


	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}


	public BigDecimal getPrecio() {
		return precio;
	}


	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public ProductoFinal getProdFinal() {
		return prodFinal;
	}


	public void setProdFinal(ProductoFinal prodFinal) {
		this.prodFinal = prodFinal;
	}


	@Override
	public String toString() {
		return "MateriaPrima [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", fechaCaducidad=" + fechaCaducidad
				+ ", precio=" + precio + ", prodFinal=" + prodFinal + "]";
	} 
	
}
