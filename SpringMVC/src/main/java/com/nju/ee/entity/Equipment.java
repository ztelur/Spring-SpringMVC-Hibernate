package com.nju.ee.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by zangxiaojie on 2016/11/2.
 */
@Entity
@Table(name="equipment")
public class Equipment {
    private int id;
    private String name;
    private String description;
    public Equipment(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
