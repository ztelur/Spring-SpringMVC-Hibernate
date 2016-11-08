package com.nju.ee.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by zangxiaojie on 2016/11/3.
 */
@Entity
@Table
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
    private String url;

    @ManyToMany (fetch = FetchType.LAZY,mappedBy = "people")
    private Set<Team> teams;

    public Person(){

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
