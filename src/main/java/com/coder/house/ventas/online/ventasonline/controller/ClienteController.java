package com.coder.house.ventas.online.ventasonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coder.house.ventas.online.ventasonline.entidad.Cliente;
import com.coder.house.ventas.online.ventasonline.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> findAll() {
		return this.clienteService.findAll();
	}

	// Single item

	@GetMapping("/{id}")
	public Cliente one(@PathVariable Integer id) {
		
		return this.clienteService.findById(id);
	}

	@PutMapping("/{id}")
	public Cliente update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		return this.clienteService.update(id, cliente);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		try {
			clienteService.delete(id);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Cliente newEntity(@RequestBody Cliente cliente) {
		return this.clienteService.save(cliente);
	}
}