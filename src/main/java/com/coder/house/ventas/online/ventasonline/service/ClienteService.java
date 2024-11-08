package com.coder.house.ventas.online.ventasonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.house.ventas.online.ventasonline.entidad.Cliente;
import com.coder.house.ventas.online.ventasonline.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	public Cliente findById(Integer id) {
		
		var opCliente =  this.clienteRepository.findById(id);
		if (opCliente.isPresent()) {
			return opCliente.get();
		} else {
			return new Cliente();
		}
	}


	public Cliente update(Integer id, Cliente cliente) {
		// Verifica si el cliente existe
		if (!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("El cliente con ID " + id + " no existe.");
		}

		// Obtiene el cliente existente
		Cliente existingCliente = clienteRepository.findById(id).get();

		// Actualiza los campos del cliente existente
		existingCliente.setNombre(cliente.getNombre());
		existingCliente.setApellido(cliente.getApellido());
		existingCliente.setDni(cliente.getDni());
		existingCliente.setEmail(cliente.getEmail()); // Actualiza el email
		existingCliente.setTelefono(cliente.getTelefono()); // Actualiza el teléfono
		existingCliente.setDireccion(cliente.getDireccion()); // Actualiza la dirección
		existingCliente.setFechaRegistro(cliente.getFechaRegistro()); // Actualiza la fecha de registro

		// Guarda el cliente actualizado
		return clienteRepository.save(existingCliente);
	}

	public void delete(Integer id) {
		if (!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("El cliente con ID " + id + " no existe.");
		}

		clienteRepository.deleteById(id);
	}
	
}
