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

import com.idat.Examen2.dto.BodegaRequestDTO;
import com.idat.Examen2.dto.BodegaResponseDTO;
import com.idat.Examen2.servicio.BodegaServicio;

@RestController
@RequestMapping("/bodega/v1")
public class BodegaControlador {

	@Autowired
	private BodegaServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<BodegaResponseDTO>> listarBodega(){
		return new ResponseEntity<List<BodegaResponseDTO>>(servicio.listarBodega(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody BodegaRequestDTO bodega){
		
		servicio.guardarBodega(bodega);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<BodegaResponseDTO> listarBodId(@PathVariable Integer id) {
		BodegaResponseDTO p = servicio.obtenerBodegaId(id);
		if(p != null)
			return new ResponseEntity<BodegaResponseDTO>(p, HttpStatus.OK);
					
		return new ResponseEntity<BodegaResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody BodegaRequestDTO bodega){
		
		BodegaResponseDTO p = servicio.obtenerBodegaId(bodega.getIdBodegaDTO());
		if(p != null) {
			servicio.editarBodega(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		BodegaResponseDTO p = servicio.obtenerBodegaId(id);
		if(p != null) {
			servicio.eliminarBodega(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
}
