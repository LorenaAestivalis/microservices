package com.vista.thymeleaf.controller;

/*
*  7.Agregar informacion al modelo para desplegarla en la vista
*  8.Configurar la plantilla de Archivos HTML
*  9.Agregar tipos de datos simples al modelo y despelgarlos en la vista
* 10.Interaccion en thymeleaf-Expresion theach
* 11.Crear la clase de modelo Vacante para representar una oferta de trabajo
* 12. Agregar tipo de dato vacante el modelo y desplegarlo en la vista
* 13.Agregar el tipo de ListVacante al modelo y desplegarlo en la vista
* 14.Integrar Bootstrap en una App Web via CDN
* 15.Condiciones thymeleaf
* 16.Condiciones thymeleaf
* 17.
* 18.Incluir imagenesestaticas en las vistas
* 19.Incluir imagenes dinamicas en la vista
* 20.Arquiectura MVC, Ciclo de vida de una peticion
* */

import com.vista.thymeleaf.model.Vacante;
import com.vista.thymeleaf.service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HOmeController {
    //Inyectamosnuestra clase de servico en  nuestro controlador
    @Autowired
    IVacantesService vacantesService;

    @GetMapping("/tabla")
    public String mostrarTable(Model model){
        List<Vacante> lista =vacantesService.buscarTodo();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de comunicaciones");
        vacante.setDescripcion("Se solita ingeniero para dr soporte a internet");
        vacante.setFecha(new Date());
        vacante.setSalario(97000.0);
        vacante.setDestacado(1);

        model.addAttribute("vacante",vacante);
        return "detalle";
    }
    @GetMapping("/listado")
   public String mostrarListado(Model model){
       List<String> lista = new LinkedList<String>();
       lista.add("Ingeniero de sistemas");
       lista.add("Auxiliar de Contabilidad");
       lista.add("Vendedor");
       lista.add("Arquitecto");
       model.addAttribute("empleos",lista);
    return "listado";
   }

    @GetMapping("/")
    public String home(Model model){
        /*model.addAttribute("mensaje","HOla");
        model.addAttribute("fecha",new Date());


        String nombre ="Auxiliar Contable";
        Date fechaPub =new Date();
        double salario =90000.0;
        boolean vigente = true;


        model.addAttribute("nombre",nombre);
        model.addAttribute("fecha",fechaPub);
        model.addAttribute("salario",salario);
        model.addAttribute("vigente",vigente);*/

        List<Vacante> lista =vacantesService.buscarTodo();
        model.addAttribute("vacantes", lista);


        return "home";
    }
}