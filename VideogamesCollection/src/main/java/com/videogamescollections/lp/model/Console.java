package com.videogamescollections.lp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Console implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private int produttore;
	
	private int anno;
	
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
	
	public int getProduttore() {
		return produttore;
	}

	public void setProduttore(int produttore) {
		this.produttore = produttore;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Console() {
		
	}
	
	public Console(int id, String nome, int produttore, int anno) {
		this.id = id;
		this.nome = nome;
		this.produttore = produttore;
		this.anno = anno;
	}
	
//	@Override
//	public int hashCode() {
//		int hash = 7;
//		hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
//		return hash;
//	}
//	
	
}
