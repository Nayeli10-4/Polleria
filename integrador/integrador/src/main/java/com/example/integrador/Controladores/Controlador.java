
package com.example.integrador.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
     @GetMapping({"/contacto"})
    public String contacto(Model model) {
        return "contacto";
    }
     @GetMapping("/menu")
    public String carta(Model model) {
        return "menu";
    }

    
     @GetMapping("/ladmin")
    public String login(Model model) {
        return "ladmin";
    }
    @GetMapping("/comentario")
    public String sugerencias(Model model) {
        return "comentario";
    }
    @GetMapping("/reclamaciones")
    public String reclamaciones(Model model) {
        return "reclamaciones";
    }
    @GetMapping("/fromcompra")
    public String fromclient(Model model) {
        return "fromcompra";
    }
    
    @RequestMapping("/dataclientfrom")
    public String dataclientfrom(@RequestParam("nombre") String nombre,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("correo") String correo,
            @RequestParam("numero") String numero,
            @RequestParam("direccion") String direccion,
            Model model
    ) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellidos", apellidos);
        model.addAttribute("correo", correo);
        model.addAttribute("numero", numero);
        model.addAttribute("direccion", direccion);
        return "clienteform";
    }
    
    @GetMapping("/carrito")
    public String especificaciones(Model model) {
        return "carrito";
    }
    
}
