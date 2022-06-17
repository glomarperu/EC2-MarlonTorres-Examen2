package com.idat.Examen2.servicio;

import java.util.List;

import com.idat.Examen2.dto.ClienteRequestDTO;
import com.idat.Examen2.dto.ClienteResponseDTO;


public interface ClienteServicio {
	public void guardarCliente(ClienteRequestDTO cliente);
	public void editarCliente(ClienteRequestDTO cliente);
	public void eliminarCliente(Integer id);
	public List<ClienteResponseDTO> listarClientes();
	public ClienteResponseDTO obtenerClienteId(Integer id);
}
