package com.idat.Examen2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Examen2.modelo.Bodega;
@Repository
public interface BodegaRepo extends JpaRepository<Bodega, Integer> {

}
