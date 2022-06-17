package com.idat.Examen2.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen2.dto.ClienteRequestDTO;
import com.idat.Examen2.dto.ClienteResponseDTO;
import com.idat.Examen2.modelo.Cliente;
import com.idat.Examen2.repositorio.ClienteRepo;

@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	public ClienteRepo repositorio;
	
	@Override
	public void guardarCliente(ClienteRequestDTO cliente) {
		Cliente obj = new Cliente();
		obj.setIdCliente(cliente.getIdClienteDTO());
		obj.setNombrecliente(cliente.getNombreclienteDTO());
		obj.setDireccion(cliente.getDireccionDTO());
		obj.setDni(cliente.getDniDTO());
		
		repositorio.save(obj);

	}

	@Override
	public void editarCliente(ClienteRequestDTO cliente) {
		Cliente obj = new Cliente();
		obj.setIdCliente(cliente.getIdClienteDTO());
		obj.setNombrecliente(cliente.getNombreclienteDTO());
		obj.setDireccion(cliente.getDireccionDTO());
		obj.setDni(cliente.getDniDTO());

		repositorio.saveAndFlush(obj);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repositorio.deleteById(id);;

	}

	@Override
	public List<ClienteResponseDTO> listarClientes() {

		List<ClienteResponseDTO> lista = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO obj = null;
		
		for(Cliente cliente : repositorio.findAll()) {
			obj = new ClienteResponseDTO();
			obj.setIdClienteDTO(cliente.getIdCliente());
			obj.setNombreclienteDTO(cliente.getNombrecliente());
			obj.setDireccionDTO(cliente.getDireccion());
			obj.setDniDTO(cliente.getDni());
			lista.add(obj);
		}
		
		return lista;
	}

	@Override
	public ClienteResponseDTO obtenerClienteId(Integer id) {

		Cliente cliente = repositorio.findById(id).orElse(null);
		ClienteResponseDTO obj = new ClienteResponseDTO();
		obj.setIdClienteDTO(cliente.getIdCliente());
		obj.setNombreclienteDTO(cliente.getNombrecliente());
		obj.setDireccionDTO(cliente.getDireccion());
		obj.setDniDTO(cliente.getDni());
		
		return obj;
	}

}
