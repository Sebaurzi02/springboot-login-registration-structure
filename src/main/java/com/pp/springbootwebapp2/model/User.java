package com.pp.springbootwebapp2.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users",uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_ruoli",
        joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ruoli_id",referencedColumnName = "id")
        )
    private Set<Ruolo> ruoli;

    public User(){

    }

    public User(long id,String name , String password , Set<Ruolo> ruoli){
        this.id=id;
        this.name = name;
        this.password = password;
        this.ruoli = ruoli;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public Set<Ruolo> getRuoli(){
        return ruoli;
    }

    public void setRuoli(Set<Ruolo> ruoli){
        this.ruoli=ruoli;
    }
}
