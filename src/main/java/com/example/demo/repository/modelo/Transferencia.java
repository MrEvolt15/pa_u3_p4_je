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
@Table
@Entity
public class Transferencia {
	@GeneratedValue(generator = "seq_transferencia",strategy = GenerationType.SEQUENCE)// con el strategy le decimos explicitamente que vamos a trabajar con una secuencia
	@SequenceGenerator(name="seq_transferencia",sequenceName ="seq_transferencia",allocationSize = 1 ) //el AllocactionSize debe coincidir cone el incremento de mi BD
	@Id
	@Column(name= "trans_id")
	private Integer id;
	
	@Column(name= "trans_fecha")
	private LocalDate fecha;
	
	@Column(name= "trans_monto")
	private BigDecimal monto;
	
	@ManyToOne()
	@JoinColumn(name = "ctaO_trans_id")
	private CtaBancaria ctaOrigen;
	
	@ManyToOne()
	@JoinColumn(name = "ctaD_trans_id")
	private CtaBancaria ctaDestino;

	//SETS Y GETS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public CtaBancaria getCtaOrigen() {
		return ctaOrigen;
	}

	public void setCtaOrigen(CtaBancaria ctaOrigen) {
		this.ctaOrigen = ctaOrigen;
	}

	public CtaBancaria getCtaDestino() {
		return ctaDestino;
	}

	public void setCtaDestino(CtaBancaria ctaDestino) {
		this.ctaDestino = ctaDestino;
	}
	
	
}
