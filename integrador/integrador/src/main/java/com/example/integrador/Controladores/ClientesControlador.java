
package com.example.integrador.Controladores;

import com.example.integrador.Entidades_Model.Clientes;
import com.example.integrador.Services.ServicioClientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientesControlador {
    
    @Autowired
    ServicioClientes servicioCliente;
    
    @GetMapping("/clientelista")
    public String Clienteslista(Model model) {
        List<Clientes> lista = servicioCliente.getList();
        model.addAttribute("lista", lista);
        
        return "clientelista";
    }
    
    @GetMapping("/formclientes")
    public String formClientes(Model model) {
        model.addAttribute("clientes", new Clientes());
        return "formclientes";
    }
    
    @PostMapping("/registrarclientes")
    public String registrarClientes(@ModelAttribute Clientes clientes, Model model) {
        try {
            servicioCliente.save(clientes);
            return "redirect:/clientelista";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", e.getMessage().toString());
            model.addAttribute("clientes", clientes);
            return "formclientes";
        }
    }
    
    @GetMapping("/getEdit/{codigoclientes}")
    public String editarFormClientes(Model model, @PathVariable("codigoclientes") Long id) {
        Clientes clientes = servicioCliente.get(id);
        model.addAttribute("clientes", clientes);
        return "formclientes";
    }
    @GetMapping("/delete")
    public String eliminarFormClientes(Model model, @RequestParam("id") Long id) {
        servicioCliente.delete(id);
        return "redirect:/clientelista";
    }
    
    
    
    
    
}
