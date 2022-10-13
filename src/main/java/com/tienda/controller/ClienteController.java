
package com.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;


@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }
    
    @PostMapping("/cliente/guardar/")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String nuevoCliente(Cliente cliente) {
        
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminararCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        
        cliente = clienteService.delete(cliente);
        
        return "redirect:/";
    }
        
            
}
