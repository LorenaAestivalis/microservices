package com.vista.thymeleaf.repository;

import com.vista.thymeleaf.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
