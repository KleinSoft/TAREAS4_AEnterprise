package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Salon
 *
 */
@Entity
@Table(name="SALONES")
public class Salon implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String nombre;
	@Column
	private int capacidadMaxima;
	@Column
	private boolean practica;
	
	
	private Tipo tipo;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<Material> materiales = new ArrayList<>();
	
	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public boolean isPractica() {
		return practica;
	}

	public void setPractica(boolean practica) {
		this.practica = practica;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Salon() {
		super();
	} 
	
   
}
