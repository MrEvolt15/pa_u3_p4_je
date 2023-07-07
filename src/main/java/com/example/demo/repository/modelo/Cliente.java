package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {
	
	@GeneratedValue(generator = "seq_cliente",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_cliente",sequenceName ="seq_cliente",allocationSize = 1 )
	@Id
	@Column(name = "cli_id")
	private Integer id;
	@Column(name = "cli_nombre")
	private String nomCli;
	@Column(name = "cli_cedula")
	private String cedula;
	@Column(name = "cli_genero")
	private String genero;
	
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
	private List<Producto> productos;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomCli() {
		return nomCli;
	}
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nomCli=" + nomCli + ", cedula=" + cedula + ", genero=" + genero + ", productos="
				+ productos + "]";
	}
	
	
}
