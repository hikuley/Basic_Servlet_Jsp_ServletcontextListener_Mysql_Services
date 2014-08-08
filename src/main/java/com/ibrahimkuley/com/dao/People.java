package com.ibrahimkuley.com.dao;

/**
 * Created by halil on 05.08.2014.
 */

public class People {
    private Integer id;
    private String firstname, lastname, gender;

    public People(String firstname, String lastname, String gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public People(Integer id, String firstname, String lastname, String gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
