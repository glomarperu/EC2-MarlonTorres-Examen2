package com.idat.Examen2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Examen2.modelo.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
	Usuario findByUsuario(String usuario);
}
