package com.pp.springbootwebapp2.services;

import java.util.List;
import java.util.Optional;

import com.pp.springbootwebapp2.model.User;
import com.pp.springbootwebapp2.transferdata.UserDt;

public interface UserService {
    void salvaUtente(UserDt userDt);

    Optional<User> findById(Integer id);
    
    List<UserDt> findAllUsers();
}
