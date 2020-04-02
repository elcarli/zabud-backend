package com.zabud.prueba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabud.prueba.dto.ProductoDto;
import com.zabud.prueba.service.ProductoService;



@CrossOrigin
@RestController
@RequestMapping("/v1")
public class ProductoController {
	
	@Autowired
	ProductoService service;
	
	@PostMapping("/producto")
	public boolean add(@RequestBody @Valid ProductoDto productoDto) {
		return service.crear(productoDto);
	}
	
	@PutMapping("/producto/{id}")
	public boolean set(@RequestBody @Valid ProductoDto productoDto, @PathVariable("id") long id) {
		return service.editar(productoDto, id);
	}
	
	@DeleteMapping("/producto/{id}")
	public boolean delete(@PathVariable("id") long id) {
		
		return service.borrar(id);
	}
	
	@GetMapping("/allProducto")
	public List<ProductoDto> listar() {
		return service.obtener();
	}
}