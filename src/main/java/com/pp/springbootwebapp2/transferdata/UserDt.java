package com.pp.springbootwebapp2.transferdata;

public class UserDt {
    private Integer id;
    private String name;
    private String password;

    public UserDt(){}

    public UserDt(String name , String password,Integer id){
        this.id=id;
        this.name = name;
        this.password = password;
    }


    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
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
}
