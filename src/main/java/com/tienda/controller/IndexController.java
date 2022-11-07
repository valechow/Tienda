
package com.tienda.controller;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;


@Controller
public class IndexController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        
        var articulos = articuloService.getArticulos(true);
        
        model.addAttribute("articulos",articulos);
        
        return "index";
    }
        
            
}
