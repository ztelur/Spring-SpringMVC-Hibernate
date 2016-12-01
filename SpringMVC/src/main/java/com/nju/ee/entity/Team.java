package com.nju.ee.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by zangxiaojie on 2016/11/3.
 */
@Entity
@Table(name="team")
public class Team {
    @Id
    @GeneratedValue
    private int id;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="team_person",joinColumns = {
            @JoinColumn(name="team_id",nullable = false,updatable = false)
    },inverseJoinColumns = {@JoinColumn(name="person_id",nullable = false,updatable = false)})
    private Set<Person> people;


    public Team(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
