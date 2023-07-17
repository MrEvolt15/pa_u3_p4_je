package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity
public class CtaBancaria {
	
	
	@GeneratedValue(generator = "seq_ctabancaria",strategy = GenerationType.SEQUENCE)// con el strategy le decimos explicitamente que vamos a trabajar con una secuencia
	@SequenceGenerator(name="seq_ctabancaria",sequenceName ="seq_ctabancaria",allocationSize = 1 ) //el AllocactionSize debe coincidir cone el incremento de mi BD
	@Id
	@Column(name= "cta_id")
	private Integer id;
	
	@Column(name= "cta_numero")
	private String numero;
	
	@Column(name= "cta_tipo")
	private String tipo;
	
	
	@Column(name= "cta_saldo")
	private BigDecimal saldo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prop_cta_id")
	private Propietario propietario;
	
	@OneToMany(mappedBy = "ctaOrigen", fetch = FetchType.LAZY)
	private List<Transferencia> transferenciasPerformed; 
	@OneToMany(mappedBy = "ctaDestino", fetch = FetchType.LAZY)
	private List<Transferencia> transferenciaRecived;
	
	//SETS Y GETS
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public List<Transferencia> getTransferenciasPerformed() {
		return transferenciasPerformed;
	}
	public void setTransferenciasPerformed(List<Transferencia> transferenciasPerformed) {
		this.transferenciasPerformed = transferenciasPerformed;
	}
	public List<Transferencia> getTransferenciaRecived() {
		return transferenciaRecived;
	}
	public void setTransferenciaRecived(List<Transferencia> transferenciaRecived) {
		this.transferenciaRecived = transferenciaRecived;
	}
	
	
}
