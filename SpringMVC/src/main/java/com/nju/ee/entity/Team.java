package com.nju.ee.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zangxiaojie on 2016/11/3.
 */
@Entity
@Table
public class Team {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany(targetEntity = Person.class,mappedBy = "team")
    private List<Person> people;


    public Team(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
