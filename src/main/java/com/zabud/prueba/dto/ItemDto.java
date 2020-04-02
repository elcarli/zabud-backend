package com.zabud.prueba.dto;

import com.zabud.prueba.entity.Item;

public class ItemDto {

	private long id;
	private int cantidad;
	private double valorTotal;
	private double valorVentaUnidad;
	private long facturaId;
	private long productoId;
	private String productoNombre;
	
	public ItemDto() {
		
	}
	
	//se crea un ItemDto a partir de un objeto tipo Item
	public ItemDto(Item item) {
		this.id = item.getId();
		this.cantidad = item.getCantidad();
		this.valorVentaUnidad = item.getValorVentaUnidad();
		this.valorTotal = item.getValorTotal();
		this.facturaId = item.getFactura().getId();
		this.productoId = item.getProducto().getId();
		this.productoNombre = item.getProducto().getNombre();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorVentaUnidad() {
		return valorVentaUnidad;
	}

	public void setValorVentaUnidad(double valorVentaUnidad) {
		this.valorVentaUnidad = valorVentaUnidad;
	}

	public long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(long facturaId) {
		this.facturaId = facturaId;
	}

	public long getProductoId() {
		return productoId;
	}

	public void setProductoId(long productoId) {
		this.productoId = productoId;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}
	
	
	
}
