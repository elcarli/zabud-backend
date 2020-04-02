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
@Table (name="factura")
@Entity
public class Factura implements Serializable {
	
	public Factura() {
		
	}
	
	public Factura(long id, String clienteId) {
		this.id = id;
		this.clienteId = clienteId;
		getTotalItem();
	}
	
	//El valor total al ser un campo calculado, no se debe guardar en la BD
	private double valorTotal = 0;

	@GeneratedValue
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="clienteId")
	private String clienteId;
	
	//Relacion de Una Factura a muchos Items
	@OneToMany(mappedBy = "factura")
	private List<Item> items = new ArrayList<>();
	
	
	//se suman los valores totales de cada Item al total de la factura
	private void addTotal(double valor) {
		this.valorTotal += valor;
	}
	
	private void getTotalItem() {
		this.items.forEach(item -> this.addTotal(item.getValorTotal()));
		
	}

	
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
		getTotalItem();
	}
	
	
}
