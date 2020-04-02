package com.zabud.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.zabud.prueba.converter.Conversor;
import com.zabud.prueba.dto.FacturaDto;
import com.zabud.prueba.entity.Factura;
import com.zabud.prueba.entity.Item;
import com.zabud.prueba.repository.IFactura;
import com.zabud.prueba.repository.IItem;

@CrossOrigin
@Service("FacturaService")
public class FacturaService {
	@Autowired
	private IFactura repoFactura;
	
	@Autowired
	private IItem repoItem;
	
	@Autowired
	private Conversor conversor;
	
	//---------------------------Crear
	public long crear(FacturaDto facturaDto) {
		try {
			
			//Creo una instancia de Factura con los datos del DTO
			Factura factura = conversor.convertFacturaDtoToFactura(facturaDto);
			
			Factura newFactura = repoFactura.save(factura);
						
			return newFactura.getId();
			
		}catch(Exception e) {
			return -1;
		}
	}
	
	//---------------------------Calcular el total de la factura
	public double calcular(long facturaId) {
			
		Factura factura = repoFactura.findById(facturaId);
		List<Item> listaItem = repoItem.findByFactura(facturaId);
		
		factura.setItems(listaItem);
		
		double total = 0;
		
		if (factura != null) {
			total = factura.getValorTotal();
		}
		
		return total;
	}
	

}
