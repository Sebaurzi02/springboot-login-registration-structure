package com.pp.springbootwebapp2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pp.springbootwebapp2.transferdata.UserDt;

@Controller
public class HomeController {
    
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
    
}
