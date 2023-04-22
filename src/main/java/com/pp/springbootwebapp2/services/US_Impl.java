package com.pp.springbootwebapp2.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pp.springbootwebapp2.Repository.RuoliRepository;
import com.pp.springbootwebapp2.Repository.UserRepository;
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

    @Override
    public void salvaUtente(UserDt userDt){
        
    }

    
}
