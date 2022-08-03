package com.videogamescollections.lp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Console implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "produttore")
	@JsonManagedReference
	@NotNull
	public Produttore produttore;
	
	private int anno;
	
	@OneToMany(targetEntity = Videogame.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
	@JoinColumn(name="console")
	@JsonManagedReference
	private List<Videogame> videogames;
	
	

	
	public List<Videogame> getVideogames(){
		return videogames;
	}
	
	public void setVideogames(List<Videogame> videogames) {
		this.videogames = videogames;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Produttore getProduttore() {
		return produttore;
	}

	public void setProduttore(Produttore produttore) {
		this.produttore = produttore;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Console() {
		super();
	}

	public Console(int id, String nome, Produttore produttore, int anno) {
		this.id = id;
		this.nome = nome;
		this.produttore = produttore;
		setAnno(anno);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
