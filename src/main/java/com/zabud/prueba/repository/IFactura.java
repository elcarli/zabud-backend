package com.zabud.prueba.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zabud.prueba.entity.Factura;

@Repository("repoFactura")
public interface IFactura extends JpaRepository<Factura, Serializable> {
	
	
	public abstract Factura findById(long id);	

}