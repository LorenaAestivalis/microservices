package com.vista.thymeleaf.service;

import com.vista.thymeleaf.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/*
*2.Se recomienda poner la anotacion @Service en la clase que implementa el servicio
* 1.Por defecto, las clase de servico tienen alcance Singleton(una sola instacia de la clase para toda la aplicacion)
* */

@Service
public class VacantesServiceImpl implements IVacantesService{

    public List<Vacante> lista = null;
    public VacantesServiceImpl(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyyy");
        lista =new LinkedList<Vacante>();
        try{
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero de comunicaciones");
            vacante1.setDescripcion("Se solita ingeniero para dr soporte a internet");
            vacante1.setFecha(new Date());
            vacante1.setSalario(97000.0);
            vacante1.setDestacado(1);
            vacante1.setImagen("empresa1.png");


            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Ingeniero industrial");
            vacante2.setDescripcion("Se solita ingeniero paradirigir operaciones.");
            vacante2.setFecha(new Date());
            vacante2.setSalario(97000.0);
            vacante2.setDestacado(0);


            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero de sistemas");
            vacante3.setDescripcion("Se solita ingeniero para desarrollar  servcios web");
            vacante3.setFecha(new Date());
            vacante3.setSalario(97000.0);
            vacante3.setDestacado(1);
            vacante3.setImagen("empresa2.png");


            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
        }catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }

    }
    public List<Vacante> buscarTodo() {



        return lista;
    }

    @Override
    public Vacante buscarPorId(Integer idVacante) {
        for(Vacante v : lista){
            if(v.getId() == idVacante){
                return v;
            }
        }

        return null;
    }

    @Override
    public void guaradar(Vacante vacante) {
        lista.add(vacante);

    }
}
