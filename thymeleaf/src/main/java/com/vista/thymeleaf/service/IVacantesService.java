package com.vista.thymeleaf.service;

import com.vista.thymeleaf.model.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> buscarTodo();
     Vacante buscarPorId(Integer idVacante);
     void guaradar(Vacante vacante);
}



