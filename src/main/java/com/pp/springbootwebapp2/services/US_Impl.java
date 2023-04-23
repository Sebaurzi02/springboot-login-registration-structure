package com.pp.springbootwebapp2.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
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

    private UserDt mapToUserDt(User utente){
        UserDt userDt = new UserDt();
        userDt.setName(utente.getName());
        return userDt; 
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

    @Override
    public Optional<User> findById(Integer id){
        if(userRepository.findById(id).isPresent()){
            return userRepository.findById(id);
        }
        else return null;
    }

    @Override
    public List<UserDt> findAllUsers(){
        List<User> utenti = userRepository.findAll();
        return utenti.stream().map((utente) -> mapToUserDt(utente)).collect(Collectors.toList());
    }
}
