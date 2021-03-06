package com.alkemy.disney.web.controller;

import com.alkemy.disney.domain.EmailForm;
import com.alkemy.disney.domain.service.EmailService;
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

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private EmailService mailService;

    @GetMapping("auth/login")
    public String login (Model model){
        model.addAttribute("usuario", new Usuario());

        return "login";
    }

    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("usuario", new Usuario());

        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model){
        String mensaje = "Bienvenido " + usuario.getUsername() + " a DinseyAPI";

        if(result.hasErrors()){
            return "redirect:/auth/registro";
        } else {
            model.addAttribute("usuario", usuarioService.registrar(usuario));
            mailService.sendMail("feltom1000@hotmail.com", usuario.getMail(), "¬°Bienvenido/a!", mensaje);
        }
        return "redirect:/auth/login";
    }
}
