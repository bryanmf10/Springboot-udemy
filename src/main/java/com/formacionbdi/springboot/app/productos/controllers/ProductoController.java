package com.formacionbdi.springboot.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.models.service.IProductoService;

@RestController //Indica que es un controlador REst, Retorna una lista que se convierte en un estructura json
public class ProductoController {
	
	//Inyeccion de dependencias
	@Autowired
	private IProductoService productoService;
	
	//Mapear a una ruta url o poner en una ruta o endpoint
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	//el {id} lo pasa por argumento a este metodo
	@GetMapping("/listar/{id}")
	public Producto detalle(@PathVariable Long id) {//@PathVariable es para pasar el argumento del endpoint
		return productoService.findById(id);//aqui lo busca en la base de datos
	}

}
