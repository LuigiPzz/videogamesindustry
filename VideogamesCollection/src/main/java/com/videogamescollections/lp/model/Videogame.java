package com.videogamescollections.lp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.EqualsAndHashCode;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Videogame implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String titolo;
	
	@NotNull
	private Boolean posseduto;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "console")
	public Console console;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serie")
	public Serie serie;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Boolean getPosseduto() {
		return posseduto;
	}

	public void setPosseduto(Boolean posseduto) {
		this.posseduto = posseduto;
	}

	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Videogame() {
		super();
	}
	
	public Videogame(int id, String titolo, Boolean posseduto, Console console, Serie serie) {
		this.id = id;
		this.titolo = titolo;
		this.posseduto = posseduto;
		this.console = console;
		this.serie = serie;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
