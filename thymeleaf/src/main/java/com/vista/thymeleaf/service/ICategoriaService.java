package com.vista.thymeleaf.service;

import com.vista.thymeleaf.model.Categoria;

import java.util.List;

public interface ICategoriaService {
    void guardar (Categoria categoria);
    List<Categoria> buscarTodo();
    Categoria buscarPorId(Integer idCategoria);
}
