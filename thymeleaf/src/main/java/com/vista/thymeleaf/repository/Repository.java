package com.vista.thymeleaf.repository;

import com.vista.thymeleaf.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//public interface Repository extends CrudRepository<Categoria, Integer>
public interface Repository extends JpaRepository<Categoria, Integer> {


}
