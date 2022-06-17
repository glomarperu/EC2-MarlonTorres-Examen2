package com.idat.Examen2.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen2.dto.BodegaRequestDTO;
import com.idat.Examen2.dto.BodegaResponseDTO;
import com.idat.Examen2.modelo.Bodega;
import com.idat.Examen2.repositorio.BodegaRepo;

@Service
public class BodegaServicioImpl implements BodegaServicio {

	@Autowired
	public BodegaRepo repositorio;
	
	@Override
	public void guardarBodega(BodegaRequestDTO bodega) {
		Bodega obj = new Bodega();
		obj.setIdBodega(bodega.getIdBodegaDTO());
		obj.setNombrebodega(bodega.getNombrebodegaDTO());
		obj.setDirección(bodega.getDirecciónDTO());
		
		repositorio.save(obj);

	}

	@Override
	public void editarBodega(BodegaRequestDTO bodega) {
		Bodega obj = new Bodega();
		obj.setIdBodega(bodega.getIdBodegaDTO());
		obj.setNombrebodega(bodega.getNombrebodegaDTO());
		obj.setDirección(bodega.getDirecciónDTO());

		repositorio.saveAndFlush(obj);
	}

	@Override
	public void eliminarBodega(Integer id) {
		
		repositorio.deleteById(id);;

	}

	@Override
	public List<BodegaResponseDTO> listarBodega() {

		List<BodegaResponseDTO> lista = new ArrayList<BodegaResponseDTO>();
		BodegaResponseDTO obj = null;
		
		for(Bodega bodega : repositorio.findAll()) {
			obj = new BodegaResponseDTO();
			obj.setIdBodegaDTO(bodega.getIdBodega());
			obj.setNombrebodegaDTO(bodega.getNombrebodega());
			obj.setDirecciónDTO(bodega.getDirección());
			
			lista.add(obj);
			
		}

		
		return lista;
	}

	@Override
	public BodegaResponseDTO obtenerBodegaId(Integer id) {

		Bodega bodega = repositorio.findById(id).orElse(null);
		BodegaResponseDTO obj = new BodegaResponseDTO();
		obj.setIdBodegaDTO(bodega.getIdBodega());
		obj.setNombrebodegaDTO(bodega.getNombrebodega());
		obj.setDirecciónDTO(bodega.getDirección());
		
		return obj;
	}

}
