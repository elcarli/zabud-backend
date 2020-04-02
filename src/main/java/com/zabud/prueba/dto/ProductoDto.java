package com.zabud.prueba.dto;

import com.zabud.prueba.entity.Producto;

public class ProductoDto {
	private long id;
	private String nombre;
	private double valor;
	
	public ProductoDto() {
		
	}
	
	
	public ProductoDto(Producto producto) {
		this.id = producto.getId();
		this.nombre = producto.getNombre();
		this.valor = producto.getValor();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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

	
	
	
}