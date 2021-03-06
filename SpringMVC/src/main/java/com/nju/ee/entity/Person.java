package com.nju.ee.entity;

import com.nju.ee.vo.PersonDescVo;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zangxiaojie on 2016/11/3.
 */
@Entity
@Table (name="person")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String level;
    private String image;
    @Type(type="text")
    private String introduction;

//    @ManyToMany (fetch = FetchType.LAZY,mappedBy = "people")
//    private Set<Team> teams;

    public Person(){

    }
    public Person (PersonDescVo vo){
        this.name = vo.getName();
        this.level = vo.getLevel();
        this.image = vo.getImageUrl();
        this.introduction = vo.getIntroduction();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
