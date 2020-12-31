package com.vista.thymeleaf.service;



import com.vista.thymeleaf.model.Categoria;
import com.vista.thymeleaf.model.Vacante;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


/*
 *2.Se recomienda poner la anotacion @Service en la clase que implementa el servicio
 * 1.Por defecto, las clase de servico tienen alcance Singleton(una sola instacia de la clase para toda la aplicacion)
 * */
@Service
public class CategoriaServiceImpl implements  ICategoriaService {
    public List<Categoria> lista = null;

    public CategoriaServiceImpl() {
        lista = new LinkedList<Categoria>();

        // Creamos algunas Categorias para poblar la lista ...

        // Categoria 1
        Categoria cat1 = new Categoria();
        cat1.setId(1);
        cat1.setNombre("Contabilidad");
        cat1.setDescripcion("Descripcion de la categoria Contabilidad");

        // Categoria 2
        Categoria cat2 = new Categoria();
        cat2.setId(2);
        cat2.setNombre("Ventas");
        cat2.setDescripcion("Trabajos relacionados con Ventas");


        // Categoria 3
        Categoria cat3 = new Categoria();
        cat3.setId(3);
        cat3.setNombre("Comunicaciones");
        cat3.setDescripcion("Trabajos relacionados con Comunicaciones");

        // Categoria 4
        Categoria cat4 = new Categoria();
        cat4.setId(4);
        cat4.setNombre("Arquitectura");
        cat4.setDescripcion("Trabajos de Arquitectura");

        // Categoria 5
        Categoria cat5 = new Categoria();
        cat5.setId(5);
        cat5.setNombre("Educacion");
        cat5.setDescripcion("Maestros, tutores, etc");

        /**
         * Agregamos los 5 objetos de tipo Categoria a la lista ...
         */
        lista.add(cat1);
        lista.add(cat2);
        lista.add(cat3);
        lista.add(cat4);
        lista.add(cat5);

    }

    public List<Categoria> buscarTodo() {
    return lista;
    }

    @Override
    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        for(Categoria v : lista){
            if(v.getId() == idCategoria){
                return v;
            }
        }

        return null;
    }


}
