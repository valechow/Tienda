
package com.tienda.controller;
import dao.ClienteDao;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.domain.Cliente;


@Controller
public class IndexController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        var texto = "Estamos en semana 4";
        model.addAttribute("mensaje", texto);
        
        
        /*Cliente cliente1 = new Cliente("Juan","Perez Moreno","jperez@gmail.com","25611818");
        Cliente cliente2 = new Cliente("Pedro","Moreno Perez ","pmoreno@gmail.com","2545278");
        Cliente cliente3 = new Cliente("Rebeca","Perez Contreras","rperez@gmail.com","22562222");
        

        var clientes = Arrays.asList(cliente1,cliente2,cliente3);*/
        
        var clientes = clienteService.getClientes();
        
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
        
            
}
