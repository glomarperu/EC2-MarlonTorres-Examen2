package com.idat.Examen2.servicio;

import java.util.List;

import com.idat.Examen2.dto.BodegaRequestDTO;
import com.idat.Examen2.dto.BodegaResponseDTO;

public interface BodegaServicio {
	public void guardarBodega(BodegaRequestDTO bodega);
	public void editarBodega(BodegaRequestDTO bodega);
	public void eliminarBodega(Integer id);
	public List<BodegaResponseDTO> listarBodega();
	public BodegaResponseDTO obtenerBodegaId(Integer id);
}
