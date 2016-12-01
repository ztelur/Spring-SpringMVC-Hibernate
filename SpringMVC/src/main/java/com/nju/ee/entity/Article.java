package com.nju.ee.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by homer on 16-10-31.
 */
@Entity
@Table(name="article")
public class Article {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private Date date;
    private String category;
    private String url;
    private int readTimes;

    private String content;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id",referencedColumnName = "id",nullable = false)
    private Person person;


    public Article() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(int readTimes) {
        this.readTimes = readTimes;
    }
}
