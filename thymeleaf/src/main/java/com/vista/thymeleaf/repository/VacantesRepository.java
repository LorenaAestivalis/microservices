package com.vista.thymeleaf.repository;

import com.vista.thymeleaf.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacantesRepository extends JpaRepository <Vacante,Integer>{
    //respetado las palabras reservada
    //La implementacion del metodo se realiza automatica en tiempo de  ejecucion
    //Select * from Vacante// where Estatus//=?
    public List<Vacante> findByEstatus(String estatus);


    //select * from Vacantes// where //destacado=1 and estatus="Aprobado"
     List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);

    //select * from vacantes where salario Between s1 And s2
    // List<Vacante> findBySalarioBetween(double s1, double s2);

    List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);


    List<Vacante> findByEstatusIn(String[] estatus);
}
