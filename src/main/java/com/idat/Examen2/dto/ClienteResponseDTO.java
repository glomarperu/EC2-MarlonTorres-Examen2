package com.idat.Examen2.dto;

public class ClienteResponseDTO {
	private Integer idClienteDTO;
	private String nombreclienteDTO;
	private String direccionDTO;
	private String dniDTO;
	public Integer getIdClienteDTO() {
		return idClienteDTO;
	}
	public void setIdClienteDTO(Integer idClienteDTO) {
		this.idClienteDTO = idClienteDTO;
	}
	public String getNombreclienteDTO() {
		return nombreclienteDTO;
	}
	public void setNombreclienteDTO(String nombreclienteDTO) {
		this.nombreclienteDTO = nombreclienteDTO;
	}
	public String getDireccionDTO() {
		return direccionDTO;
	}
	public void setDireccionDTO(String direccionDTO) {
		this.direccionDTO = direccionDTO;
	}
	public String getDniDTO() {
		return dniDTO;
	}
	public void setDniDTO(String dniDTO) {
		this.dniDTO = dniDTO;
	}
	
}
