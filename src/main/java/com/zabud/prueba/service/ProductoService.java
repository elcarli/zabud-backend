package com.zabud.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zabud.prueba.converter.Conversor;
import com.zabud.prueba.dto.ProductoDto;
import com.zabud.prueba.entity.Producto;
import com.zabud.prueba.repository.IProducto;

@Service("ProductoService")
public class ProductoService {
	@Autowired
	private IProducto repoProducto;
	
	@Autowired
	private Conversor conversor;
	
	//---------------------------Crear
	public boolean crear(ProductoDto productoDto) {
		try {
			
			//Creo una instancia de Producto con los datos del DTO
			Producto producto = conversor.convertProductoDtoToProducto(productoDto);
			
			repoProducto.save(producto);
			
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}

	//---------------------------Editar
	public boolean editar(ProductoDto productoDto, long id) {
		try {
			
			//Busco el producto al que se refiere el id
			Producto productoOld = repoProducto.findById(id);
			
			if (productoOld != null) {
				productoDto.setId(id);
				//Creo una instancia de Producto con los datos del DTO
				Producto productoNew = conversor.convertProductoDtoToProducto(productoDto);
				
				repoProducto.save(productoNew);
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
			//Busco el producto al que se refiere el id
			Producto producto = repoProducto.findById(id);
			
			if (producto != null) {
				repoProducto.delete(producto);
				
				return true;
			}
			
			return false;
			
		}catch(Exception e) {
			return false;
		}
	}
	
	//---------------------------Listar todos
	public List<ProductoDto> obtener() {
			
		List<Producto> listaProducto = repoProducto.findAll();
		
		//Convierte la lista a DTO
		return conversor.convertirListaProductos(listaProducto);
	}
	

}
