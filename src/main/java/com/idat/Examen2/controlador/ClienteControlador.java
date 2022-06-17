package com.idat.Examen2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.Examen2.dto.ClienteRequestDTO;
import com.idat.Examen2.dto.ClienteResponseDTO;
import com.idat.Examen2.servicio.ClienteServicio;


@RestController
@RequestMapping("/cliente/v1")
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteResponseDTO>> listarCliente(){
		return new ResponseEntity<List<ClienteResponseDTO>>(servicio.listarClientes(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ClienteRequestDTO cliente){
		
		servicio.guardarCliente(cliente);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ClienteResponseDTO> listarCliId(@PathVariable Integer id) {
		ClienteResponseDTO p = servicio.obtenerClienteId(id);
		if(p != null)
			return new ResponseEntity<ClienteResponseDTO>(p, HttpStatus.OK);
					
		return new ResponseEntity<ClienteResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ClienteRequestDTO cliente){
		
		ClienteResponseDTO p = servicio.obtenerClienteId(cliente.getIdClienteDTO());
		if(p != null) {
			servicio.editarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ClienteResponseDTO p = servicio.obtenerClienteId(id);
		if(p != null) {
			servicio.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
}
