package com.coder.house.ventas.online.ventasonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coder.house.ventas.online.ventasonline.entidad.Producto;
import com.coder.house.ventas.online.ventasonline.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping
	public List<Producto> findAll() {
		return this.productoService.findAll();
	}

	// Single item

	@GetMapping("/{id}")
	public Producto one(@PathVariable Integer id) {
		
		return this.productoService.findById(id);
	}

	@PostMapping
	public Producto newEntity(@RequestBody Producto producto) {
		return this.productoService.save(producto);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Producto> updateEntity(@PathVariable Integer id, @RequestBody Producto producto) {
		try {
			// Llama al servicio para actualizar el producto
			Producto updatedProducto = this.productoService.update(id, producto);
			return ResponseEntity.ok(updatedProducto); // Devuelve el producto actualizado
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build(); // Devuelve 404 si no se encuentra el producto
		}
	}
}


