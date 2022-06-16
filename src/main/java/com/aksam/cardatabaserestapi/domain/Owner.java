package com.aksam.cardatabaserestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")

    @JsonIgnore
    private List<Car> cars;
    //Getter and setter


    public Owner() {}
    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public long getOwnerid() {
        return ownerid;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
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
    public List<Car> getCars() {
        return cars;
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    @Override
    public String toString() {
        return "Owner{" +
                "ownerid=" + ownerid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cars=" + cars +
                '}';
    }
}

