package com.zabud.prueba.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zabud.prueba.entity.Producto;



@Repository("repoProducto")
public interface IProducto extends JpaRepository<Producto, Serializable> {
	
	
	public abstract Producto findById(long id);
	

}