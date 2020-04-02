package com.zabud.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabud.prueba.converter.Conversor;
import com.zabud.prueba.dto.ItemDto;
import com.zabud.prueba.entity.Factura;
import com.zabud.prueba.entity.Item;
import com.zabud.prueba.entity.Producto;
import com.zabud.prueba.repository.IFactura;
import com.zabud.prueba.repository.IItem;
import com.zabud.prueba.repository.IProducto;

@Service("ItemService")
public class ItemService {
	@Autowired
	private IItem repoItem;
	
	@Autowired
	private IProducto repoProducto;
	
	@Autowired
	private IFactura repoFactura;
	
	@Autowired
	private Conversor conversor;
	
	//---------------------------Crear
	public boolean crear(ItemDto itemDto) {
		try {
			
			//Busco el producto y la factura a la que se refiere el id
			Producto producto = repoProducto.findById(itemDto.getProductoId());
			Factura factura = repoFactura.findById(itemDto.getFacturaId());
			
			if (producto != null && factura != null) {
				
				//Creo una instancia de Item con los datos del DTO
				Item item = conversor.convertItemDtoToItem(itemDto, producto, factura);
				
				repoItem.save(item);
				
				return true;
			}
			
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}

	
	//---------------------------borrar
	public boolean borrar(long id) {
		try {
			//Busco el Item al que se refiere el id
			Item item = repoItem.findById(id);
			
			if (item != null) {
				repoItem.delete(item);
				
				return true;
			}
			
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	//---------------------------Listar todos los Items de esa factura
	public List<ItemDto> obtener(long facturaId) {
			
		List<Item> listaItem = repoItem.findByFactura(facturaId);
		
		//Convierte la lista a DTO
		return conversor.convertirListaItems(listaItem);
	}
	

}