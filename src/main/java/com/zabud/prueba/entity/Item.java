package com.zabud.prueba.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zabud.prueba.entity.Producto;

@SuppressWarnings("serial")
@Table (name="item")
@Entity
public class Item implements Serializable {
	
	public Item() {
		
	}
	
	public Item(long id, int cantidad, Producto producto, Factura factura) {
		this.id = id;
		this.cantidad = cantidad;
		this.valorVentaUnidad = producto.getValor();	//Se guarda el valor al que se vendió el producto
		this.valorTotal = this.valorVentaUnidad * this.cantidad;
		this.producto = producto;
		this.factura = factura;
		
	}
	
	//El valor total al ser un campo calculado, no se debe guardar en la BD
	private double valorTotal = 0;

	@GeneratedValue
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="valorVentaUnidad")
	private double valorVentaUnidad;
		
	
	//Relacion de Muchos Item a Un Producto
	@ManyToOne()
	//clave foranea es la id del Producto
	@JoinColumn(name = "productoId")
	private Producto producto;
	
	//Relacion de Muchos Item a Una Factura
	@ManyToOne()
	//clave foranea es la id de la Factura
	@JoinColumn(name = "facturaId")
	private Factura factura;
	
	

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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorVentaUnidad() {
		return valorVentaUnidad;
	}

	public void setValorVentaUnidad(double valorVentaUnidad) {
		this.valorVentaUnidad = valorVentaUnidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
}
