package com.pp.springbootwebapp2.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pp.springbootwebapp2.model.Ruolo;

public interface RuoliRepository extends JpaRepository<Ruolo,Long>{
    Optional<Ruolo> findByName(String name);
}
