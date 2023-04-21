package com.pp.springbootwebapp2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pp.springbootwebapp2.model.Ruolo;

public interface RuoliRepository extends JpaRepository<Ruolo,Integer>{
    Ruolo findByRname(String rname);
}
