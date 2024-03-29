package com.pp.springbootwebapp2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pp.springbootwebapp2.model.User;
import com.pp.springbootwebapp2.services.UserService;
import com.pp.springbootwebapp2.transferdata.UserDt;

import jakarta.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String home(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        UserDt utente = new UserDt();
        model.addAttribute("utente",utente);
        return "registrazione";
    }

    @PostMapping("/signup/save")
    public String registrazione(@Valid @ModelAttribute("utente") UserDt userDt, BindingResult risultato,Model model){
        User exiUser = userService.findByName(userDt.getName());
        if(exiUser!= null  && exiUser.getName() != null && !exiUser.getName().isEmpty()){
            risultato.rejectValue("name",null,"There is already  an account registered");
        }

        if(risultato.hasErrors()){
            model.addAttribute("utente", userDt);
            return "registrazione";
        }
        userService.salvaUtente(userDt);
        return "redirect:/signup?succes";
    }
    
}
