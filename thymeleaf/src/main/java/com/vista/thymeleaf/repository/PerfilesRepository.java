package com.vista.thymeleaf.repository;

import com.vista.thymeleaf.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {
}
