package com.zabud.prueba.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zabud.prueba.dto.FacturaDto;
import com.zabud.prueba.service.FacturaService;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class FacturaController {
	
	@Autowired
	FacturaService service;
	
	@PostMapping("/factura")
	public long add(@RequestBody @Valid FacturaDto facturaDto) {
		return service.crear(facturaDto);
	}
	
	@GetMapping("/calcular/{facturaId}")
	public double calcular(@PathVariable("facturaId") long facturaId) {
		return service.calcular(facturaId);
	}
}
