package com.nju.ee.vo;

import com.nju.ee.entity.Person;

import java.util.List;

/**
 * Created by homer on 16-10-31.
 */
public class PersonDescVo {
    private int id;
    private String name;
    private String title; //称为　博导，博士生导师
    private String avatar;
    private String department;
    private String position; //职位 　长江学者,ｘｘｘ主任
    private String introduction;
    //TODO 是否建立论文数据实体以及与人员的关系？
    private List<String> researchList;
    private List<String> paperList;

    public PersonDescVo() {
    }

    public PersonDescVo(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.title = person.getLevel();
        this.avatar = person.getAvatar();
        this.department = person.getDepartment();
        this.position = person.getPosition();
        this.introduction = person.getIntroduction();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<String> getResearchList() {
        return researchList;
    }

    public void setResearchList(List<String> researchList) {
        this.researchList = researchList;
    }

    public List<String> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<String> paperList) {
        this.paperList = paperList;
    }
}
