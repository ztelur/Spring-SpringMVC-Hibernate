package com.nju.ee.po;

import java.util.List;

/**
 * Created by homer on 16-10-31.
 */
public class PersonDescPo {
    private String name;
    private String title; //称为　博导，博士生导师
    private String avator;
    private String department;
    private String position; //职位 　长江学者,ｘｘｘ主任
    private String introducation;
    private List<String> researchList;
    private List<String> paperList;

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

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
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

    public String getIntroducation() {
        return introducation;
    }

    public void setIntroducation(String introducation) {
        this.introducation = introducation;
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