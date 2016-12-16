package com.nju.ee.vo;

import com.nju.ee.entity.Person;

/**
 * Created by homer on 16-10-31.
 */
public class PersonDescVo {
    private int id;
    private String name;
    private String level; //称为　博导，博士生导师
    private String image;
    private String introduction;

    public PersonDescVo() {
    }

    public PersonDescVo(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.level = person.getLevel();
        this.image = person.getImage();
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

}
