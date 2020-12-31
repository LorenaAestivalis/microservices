package com.vista.thymeleaf.controller;


import com.sun.org.apache.xalan.internal.xsltc.dom.SAXImpl;
import com.vista.thymeleaf.model.Vacante;
import com.vista.thymeleaf.service.ICategoriaService;
import com.vista.thymeleaf.service.IVacantesService;
import com.vista.thymeleaf.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping ("/vacantes")
public class VacantesController {

    //inyectamos una propiedad en la variable
    @Value("${thymeleaf.ruta.imagenes}")
    private String ruta;
    @Autowired
    IVacantesService vacantesService;

    @Autowired
    ICategoriaService iCategoriaService;



    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Vacante> lista = vacantesService.buscarTodo();
        model.addAttribute("vacantes", lista);
        return "vacantes/listVacantes";
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));

    }

    @GetMapping("/create")
    public String crear(Vacante vacante, Model model){
        model.addAttribute("categorias",iCategoriaService.buscarTodo());
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes redirectAttributes,
                          @RequestParam("archivoImagen")MultipartFile multiPart){
        if(result.hasErrors()){
            for (ObjectError error: result.getAllErrors()){
                System.out.println("**********************************************");
                System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }
        if (!multiPart.isEmpty()) {
            //String ruta = "/empleos/img-vacantes/"; // Linux/MAC
            //String ruta = "c:/empleos/img-vacantes/"; // Windows
            String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
            if (nombreImagen != null){ // La imagen si se subio
                // Procesamos la variable nombreImagen
                vacante.setImagen(nombreImagen);
            }
        }

        vacantesService.guaradar(vacante);
        System.out.println(vacante.toString());
        /*System.out.println(" Nombre vacante: " + vacante.getNombre());
        System.out.println(" Descripcion: " + vacante.getDescripcion());
        System.out.println(" Estatus: " + vacante.getEstatus());
        System.out.println(" Fecha Publicacion: " + vacante.getFecha());
        System.out.println(" Destacado: " + vacante.getDestacado());
        System.out.println(" Salario Ofrecido: " + vacante.getSalario());
        System.out.println(" Detalles: " + vacante.getDetalle());
        System.out.println("Categoria"+ vacante.getCategoria());*/

        redirectAttributes.addFlashAttribute("msg","Registro Guardado");
        return "redirect:/vacantes/index";

    }
   /* @PostMapping("/save")
    public String guardar(@RequestParam("nombre")String nombre, @RequestParam("descripcion") String descripcion,
                          @RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha,
                          @RequestParam("destacado") int destacado, @RequestParam("salario") double salario,
                          @RequestParam("detalles") String detalles){

        System.out.println(" Nombre vacante: " + nombre);
        System.out.println(" Descripcion: " + descripcion);
        System.out.println(" Estatus: " + estatus);
        System.out.println(" Fecha Publicacion: " + fecha);
        System.out.println(" Destacado: " + destacado);
        System.out.println(" Salario Ofrecido: " + salario);
        System.out.println(" Detalles: " + detalles);

        return "vacantes/listVacantes";
    }*/

    @GetMapping("/delete/{id}")
    public  String eliminar(@PathVariable("id" )int idVacante, Model model){
        System.out.println("Borrando vacante con ID: " + idVacante);
        model.addAttribute("id",idVacante);
        return"vacantes/mensaje";
    }


    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {
        Vacante vacante = vacantesService.buscarPorId(idVacante);


        System.out.println("Vacante: "+ vacante);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }



}
