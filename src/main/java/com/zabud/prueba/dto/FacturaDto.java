package com.zabud.prueba.dto;

import com.zabud.prueba.entity.Factura;

public class FacturaDto {
	private long id;
	private String clienteId;
	private double valorTotal;
	
	public FacturaDto() {
		
	}
	
	//se crea un FacturaDto a partir de un objeto tipo Factura
	public FacturaDto(Factura factura) {
		this.id = factura.getId();
		this.clienteId = factura.getClienteId();
		this.valorTotal = factura.getValorTotal();
	}
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getClienteId() {
		return clienteId;
	}


	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	
}
