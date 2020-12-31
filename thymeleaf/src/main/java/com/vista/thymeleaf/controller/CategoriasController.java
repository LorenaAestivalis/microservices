package com.vista.thymeleaf.controller;
/*
*
* */
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.vista.thymeleaf.model.Categoria;
import com.vista.thymeleaf.model.Vacante;
import com.vista.thymeleaf.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {

    @Autowired
    ICategoriaService iCategoriaService;

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public String mostrarIndex(Model model){
    List<Categoria> lista=iCategoriaService.buscarTodo();
    model.addAttribute("categorias", lista);
        return "categorias/listCategorias";
    }


    @RequestMapping(value="/create",method= RequestMethod.GET)
    public String crear(Categoria categoria){
        return"categorias/formCategoria";
    }


    @PostMapping("/save")
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            for (ObjectError error: result.getAllErrors()){
                System.out.println("**********************************************");
                System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
            }
            return "categorias/formCategoria";
        }
        // Guadamos el objeto categoria en la bd
        iCategoriaService.guardar(categoria);
        redirectAttributes.addFlashAttribute("msg","Registro Guardado");
        return "redirect:/categorias/index";

    }
}
