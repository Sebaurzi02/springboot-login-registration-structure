package com.pp.springbootwebapp2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ruoli")
public class Ruolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String rname;

    @ManyToMany(mappedBy="ruoli")
    private List<User> utenti;

    public Ruolo(){

    }

    public Ruolo(String rname, List<User> utenti){
        this.rname=rname;
        this.utenti=utenti;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }

    public String getRname(){
        return rname;
    }
    public void setRname(String rname){
        this.rname=rname;
    }

    public List<User> getUtenti(){
        return utenti;
    }

    public void setUtenti(List<User> utenti){
        this.utenti=utenti;
    }
    
}