package com.alkemy.disney.web.controller;

import com.alkemy.disney.domain.service.UsuarioService;
import com.alkemy.disney.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("usuario", new Usuario());

        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@ModelAttribute Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/auth/registro";
        } else {
            model.addAttribute("usuario", usuarioService.registrar(usuario));
        }
        return "redirect:/auth/registro";
    }
}
