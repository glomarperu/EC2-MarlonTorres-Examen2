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

import com.idat.Examen2.dto.ProductoRequestDTO;
import com.idat.Examen2.dto.ProductoResponseDTO;
import com.idat.Examen2.servicio.ProductoServicio;



@RestController
@RequestMapping("/producto/v1")
public class ProductoControlador {

	@Autowired
	private ProductoServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProductoResponseDTO>> listarProducto(){
		return new ResponseEntity<List<ProductoResponseDTO>>(servicio.listarProductos(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductoRequestDTO producto){
		
		servicio.guardarProducto(producto);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ProductoResponseDTO> listarPorId(@PathVariable Integer id) {
		ProductoResponseDTO p = servicio.obtenerProductoId(id);
		if(p != null)
			return new ResponseEntity<ProductoResponseDTO>(p, HttpStatus.OK);
					
		return new ResponseEntity<ProductoResponseDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ProductoRequestDTO producto){
		
		ProductoResponseDTO p = servicio.obtenerProductoId(producto.getIdProductoDTO());
		if(p != null) {
			servicio.editarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProductoResponseDTO p = servicio.obtenerProductoId(id);
		if(p != null) {
			servicio.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
}
