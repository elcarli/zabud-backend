package com.zabud.prueba.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table (name="producto")
@Entity
public class Producto implements Serializable {
	
	public Producto() {
		
	}
	
	public Producto(long id, String nombre, double valor) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
	}

	@GeneratedValue
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="valor")
	private double valor;

	
	//Relacion de Un producto a muchos Items
	@OneToMany(mappedBy = "producto")
	private List<Item> items = new ArrayList<>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}