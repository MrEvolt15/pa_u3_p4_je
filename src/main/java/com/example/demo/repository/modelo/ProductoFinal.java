package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class ProductoFinal {
	@GeneratedValue(generator = "seq_producto_final",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_producto_final",sequenceName ="seq_producto_final",allocationSize = 1 )
	@Id
	@Column(name = "prof_id")
	private Integer id;
	@Column(name = "prof_nombre")
	private String nomProf;
	@Column(name = "prof_receta")
	private String receta;
	
	
	@OneToMany(mappedBy = "prodFinal",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MateriaPrima> materiasPrimas;

	//SET Y GET
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomProf() {
		return nomProf;
	}


	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}


	public String getReceta() {
		return receta;
	}


	public void setReceta(String receta) {
		this.receta = receta;
	}


	public List<MateriaPrima> getMatirasPrimas() {
		return materiasPrimas;
	}


	public void setMatirasPrimas(List<MateriaPrima> matirasPrimas) {
		this.materiasPrimas = matirasPrimas;
	}


	@Override
	public String toString() {
		return "ProductoFinal [id=" + id + ", nomProf=" + nomProf + ", receta=" + receta + "]";
	}
	
}
