
package com.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ArticuloController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulos(false);
        
        model.addAttribute("articulos",articulos);
        
        return "/articulo/listado";
    }
    
    
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo) {
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar/")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/articulo/moficicar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulos",articulo);
        return "/articulo/modificar";
    }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        
       articuloService.delete(articulo);
        
        return "redirect:/articulo/listado";
    }
        
            
}
