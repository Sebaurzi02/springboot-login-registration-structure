package com.pp.springbootwebapp2.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/login")
    public String home(){
        return "login";
    }
    
}