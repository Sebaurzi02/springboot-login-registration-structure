package com.pp.springbootwebapp2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ruoli")
public class Ruolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String rname;

    public Ruolo(){

    }

    public Ruolo(long id,String rname){
        this.id=id;
        this.rname=rname;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }

    public String getRname(){
        return rname;
    }
    public void setRname(String rname){
        this.rname=rname;
    }
}