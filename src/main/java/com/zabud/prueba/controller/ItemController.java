package com.zabud.prueba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabud.prueba.dto.ItemDto;
import com.zabud.prueba.service.ItemService;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class ItemController {
	
	@Autowired
	ItemService service;
	
	@PostMapping("/item")
	public boolean add(@RequestBody @Valid ItemDto itemDto) {
		return service.crear(itemDto);
	}
	
	@DeleteMapping("/item/{id}")
	public boolean delete(@PathVariable("id") long id) {
		
		return service.borrar(id);
	}
	
	@GetMapping("/facItem/{facturaId}")
	public List<ItemDto> listar(@PathVariable("facturaId") long facturaId) {
		return service.obtener(facturaId);
	}
}