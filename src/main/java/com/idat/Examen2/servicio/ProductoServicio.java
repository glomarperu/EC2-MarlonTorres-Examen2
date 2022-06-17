package com.idat.Examen2.servicio;

import java.util.List;

import com.idat.Examen2.dto.ProductoRequestDTO;
import com.idat.Examen2.dto.ProductoResponseDTO;


public interface ProductoServicio {
	public void guardarProducto(ProductoRequestDTO producto);
	public void editarProducto(ProductoRequestDTO producto);
	public void eliminarProducto(Integer id);
	public List<ProductoResponseDTO> listarProductos();
	public ProductoResponseDTO obtenerProductoId(Integer id);
}
