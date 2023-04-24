package com.pp.springbootwebapp2.services;

import java.util.List;

import com.pp.springbootwebapp2.model.User;
import com.pp.springbootwebapp2.transferdata.UserDt;

public interface UserService {
    void salvaUtente(UserDt userDt);

    User findById(Integer id);

    User findByName(String name);
    
    List<UserDt> findAllUsers();
}
