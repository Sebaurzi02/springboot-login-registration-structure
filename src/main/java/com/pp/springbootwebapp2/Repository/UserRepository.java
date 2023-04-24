package com.pp.springbootwebapp2.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.springbootwebapp2.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findById(Integer id);
    Optional<User> findByName(String name);
}
