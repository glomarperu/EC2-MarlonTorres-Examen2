package com.idat.Examen2.modelo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Table(name = "Bodegas")
@Entity
public class Bodega {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBodega;
	private String nombrebodega;
	private String dirección;
	
	@OneToOne
	@JoinColumn(name = "id_producto", nullable = false, unique = true, 
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_producto) references Productos (id_producto)"))
	private Productos producto;

	
	public Integer getIdBodega() {
		return idBodega;
	}

	public void setIdBodega(Integer idBodega) {
		this.idBodega = idBodega;
	}

	public String getNombrebodega() {
		return nombrebodega;
	}

	public void setNombrebodega(String nombrebodega) {
		this.nombrebodega = nombrebodega;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}
	
	
	
}
