package com.nju.ee.vo;

import com.nju.ee.entity.Person;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by homer on 16-10-31.
 */
public class PersonDescVo {
    private int id;
    private String name;
    private String level; //称为　博导，博士生导师
    private String imageUrl;
    private MultipartFile image;
    private String introduction;

    public PersonDescVo() {
    }



    public PersonDescVo(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.level = person.getLevel();
        this.imageUrl = person.getImage();
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
