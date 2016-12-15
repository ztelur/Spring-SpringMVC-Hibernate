package com.nju.ee.entity;

import com.nju.ee.vo.PersonDescVo;

import javax.persistence.*;
import java.util.Set;

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
    private String avatar;
    private String department;
    private String position; //职位 　长江学者,ｘｘｘ主任
    private String introduction;
    private String url;//xx

    @ManyToMany (fetch = FetchType.LAZY,mappedBy = "people")
    private Set<Team> teams;

    public Person(){

    }
    public Person (PersonDescVo vo){
        this.name = vo.getName();
        this.level = vo.getTitle();
        this.avatar = vo.getAvatar();
        this.department = vo.getDepartment();
        this.position = vo.getPosition();
        this.introduction = vo.getIntroduction();
        //TODO url是指个人主页URL？
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
