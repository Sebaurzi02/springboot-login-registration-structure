package com.pp.springbootwebapp2.services;

import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pp.springbootwebapp2.Repository.RuoliRepository;
import com.pp.springbootwebapp2.Repository.UserRepository;
import com.pp.springbootwebapp2.model.Ruolo;
import com.pp.springbootwebapp2.model.User;
import com.pp.springbootwebapp2.transferdata.UserDt;

@Service
public class US_Impl implements UserService {

    private UserRepository userRepository;
    private RuoliRepository ruoliRepository;
    private PasswordEncoder passwordEncoder;

    public US_Impl(UserRepository userRepository, RuoliRepository ruoliRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.ruoliRepository=ruoliRepository;
        this.passwordEncoder=passwordEncoder;
    }

    private Ruolo cheackRuolo(){
        Ruolo ruolo = new Ruolo();
        ruolo.setRname("ROLE_ADMIN");
        return ruoliRepository.save(ruolo);
    }

    @Override
    public void salvaUtente(UserDt userDt){
        User utente = new User();
        utente.setName(userDt.getName());
        utente.setPassword(passwordEncoder.encode(userDt.getPassword()));

        Ruolo ruolo = ruoliRepository.findByRname("RUOLO_ADMIN");
        if(ruolo == null){
            ruolo = cheackRuolo();
        }

        utente.setRuoli(Arrays.asList(ruolo));
        userRepository.save(utente);
    }



    
}
