package com.zabud.prueba.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zabud.prueba.entity.Item;

@Repository("repoItem")
public interface IItem extends JpaRepository<Item, Serializable> {
	
	
	public abstract Item findById(long id);
	
	
	@Query(value = "SELECT i.id, i.cantidad, i.valortotal, i.valorventaunidad, i.facturaid, i.productoid, p.nombre"
			+ " FROM producto p, factura f, item i"
			+ " WHERE f.id = ?1"
			+ " AND i.facturaid = f.id"
			+ " AND i.productoid = p.id", nativeQuery = true)
	public abstract List<Item> findByFactura(long facturaId);

}
