package com.zabud.prueba.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zabud.prueba.dto.FacturaDto;
import com.zabud.prueba.dto.ItemDto;
import com.zabud.prueba.dto.ProductoDto;
import com.zabud.prueba.entity.Factura;
import com.zabud.prueba.entity.Item;
import com.zabud.prueba.entity.Producto;


@Component("conversor")
public class Conversor {
		
//-----------------------Producto------------------------------
	
	//Convertir un ProductoDto a Producto para almacenarlo en la BD
		public Producto convertProductoDtoToProducto(ProductoDto productoDto) {
				
			//Creo un Producto a partir de los datos del ProductoDto
			Producto producto = new Producto(productoDto.getId(), productoDto.getNombre(),
					productoDto.getValor());
			
			return producto;
		}
		
	//Retorna una lista para enviar en JSON
	public List<ProductoDto> convertirListaProductos(List<Producto> listaProducto) {
		List<ProductoDto> listaProductoDto = new ArrayList<>();
		listaProducto.forEach(producto -> listaProductoDto.add(new ProductoDto(producto)));
		return listaProductoDto;
	}
	
//-----------------------Factura------------------------------

	//Convertir un FacturaDto a Factura para almacenarla en la BD
		public Factura convertFacturaDtoToFactura(FacturaDto facturaDto) {
				
			//Creo un Producto a partir de los datos del ProductoDto
			Factura factura = new Factura(facturaDto.getId(), facturaDto.getClienteId());
			
			return factura;
		}	
	
//-----------------------Item------------------------------

	//Convertir un ItemDto a Item para almacenarlo en la BD
		public Item convertItemDtoToItem(ItemDto itemDto, Producto producto, Factura factura) {
				
			//Creo un Producto a partir de los datos del ProductoDto
			Item item = new Item(itemDto.getId(), itemDto.getCantidad(), producto, factura);
			
			return item;
		}
		
	//Retorna una lista para enviar en JSON
	public List<ItemDto> convertirListaItems(List<Item> listaItem) {
		List<ItemDto> listaItemDto = new ArrayList<>();
		listaItem.forEach(item -> listaItemDto.add(new ItemDto(item)));
		return listaItemDto;
	}
	
	
}