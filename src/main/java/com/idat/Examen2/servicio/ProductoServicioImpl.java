package com.idat.Examen2.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen2.dto.ProductoRequestDTO;
import com.idat.Examen2.dto.ProductoResponseDTO;
import com.idat.Examen2.modelo.Productos;
import com.idat.Examen2.repositorio.ProductoRepo;

@Service
public class ProductoServicioImpl implements ProductoServicio {

	@Autowired
	public ProductoRepo repositorio;
	@Override
	public void guardarProducto(ProductoRequestDTO producto) {
		Productos obj = new Productos();
		obj.setIdProducto(producto.getIdProductoDTO());
		obj.setNombreProducto(producto.getNombreProductoDTO());
		obj.setDescripcion(producto.getDescripcionDTO());
		obj.setPrecio(producto.getPrecioDTO());
		obj.setStock(producto.getStockDTO());

		repositorio.save(obj);
	}

	@Override
	public void editarProducto(ProductoRequestDTO producto) {
		Productos obj = new Productos();
		obj.setIdProducto(producto.getIdProductoDTO());
		obj.setNombreProducto(producto.getNombreProductoDTO());
		obj.setDescripcion(producto.getDescripcionDTO());
		obj.setPrecio(producto.getPrecioDTO());
		obj.setStock(producto.getStockDTO());
		
		repositorio.saveAndFlush(obj);

	}

	@Override
	public void eliminarProducto(Integer id) {
		repositorio.deleteById(id);;

	}

	@Override
	public List<ProductoResponseDTO> listarProductos() {
		List<ProductoResponseDTO> lista = new ArrayList<ProductoResponseDTO>();
		ProductoResponseDTO obj = null;
		
		for(Productos producto : repositorio.findAll()){
			obj = new ProductoResponseDTO();
			obj.setIdProductoDTO(producto.getIdProducto());
			obj.setNombreProductoDTO(producto.getNombreProducto());
			obj.setDescripcionDTO(producto.getDescripcion());
			obj.setPrecioDTO(producto.getPrecio());
			obj.setStockDTO(producto.getStock());
			
			lista.add(obj);
		}
		
		return lista;
	}

	@Override
	public ProductoResponseDTO obtenerProductoId(Integer id) {
Productos producto = repositorio.findById(id).orElse(null);
		
		ProductoResponseDTO obj = new ProductoResponseDTO();
		obj.setIdProductoDTO(producto.getIdProducto());
		obj.setNombreProductoDTO(producto.getNombreProducto());
		obj.setDescripcionDTO(producto.getDescripcion());
		obj.setPrecioDTO(producto.getPrecio());
		obj.setStockDTO(producto.getStock());
		return obj;
	}

}
