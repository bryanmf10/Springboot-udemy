package com.formacionbdi.springboot.app.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.productos.models.dao.ProductoDao;
import com.formacionbdi.springboot.app.productos.models.entity.Producto;

@Service//con esto lo registra como un beans
public class ProductoServiceImpl implements IProductoService{

	@Autowired//Inyectamos en la base de datos
	private ProductoDao productoDao;
	
	@Override
	@Transactional(readOnly = true) 
	public List<Producto> findAll() {
		
		return (List<Producto>) productoDao.findAll();//tendremos que hacer un cast
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		
		return productoDao.findById(id).orElse(null);//esto me retorna un optional
	}

}
