package com.coder.house.ventas.online.ventasonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.house.ventas.online.ventasonline.entidad.Producto;
import com.coder.house.ventas.online.ventasonline.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> findAll() {
		return this.productoRepository.findAll();
	}

	public Producto save(Producto cliente) {
		return this.productoRepository.save(cliente);
	}

	public Producto findById(Integer id) {
		
		var opCliente =  this.productoRepository.findById(id);
		if (opCliente.isPresent()) {
			return opCliente.get();
		} else {
			return new Producto();
		}
	}

	public Producto update(Integer id, Producto producto) {
		// Verifica si el producto existe
		if (!productoRepository.existsById(id)) {
			throw new IllegalArgumentException("El producto con ID " + id + " no existe.");
		}

		// Obtiene el producto existente
		Producto existingProducto = productoRepository.findById(id).get();

		// Actualiza los campos del producto existente
		existingProducto.setNombre(producto.getNombre());
		existingProducto.setCantidad(producto.getCantidad());
		existingProducto.setCodigo(producto.getCodigo());
		existingProducto.setDescripcion(producto.getDescripcion());
		existingProducto.setPrecio(producto.getPrecio());
		existingProducto.setCategoria(producto.getCategoria());
		existingProducto.setImagenUrl(producto.getImagenUrl());
		existingProducto.setFechaCreacion(producto.getFechaCreacion());
		existingProducto.setEstado(producto.isEstado()); // Asegúrate de que este campo se actualice

		// Guarda el producto actualizado
		return productoRepository.save(existingProducto);
	}




}
