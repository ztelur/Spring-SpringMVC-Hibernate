package com.nju.ee.entity;

import com.nju.ee.vo.ArticleVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String category;
    private String content;
    private Date date;

//    @ManyToOne(targetEntity = Person.class)
//    @JoinColumn(name = "person_id",referencedColumnName = "id",nullable = false)
//    private Person person;


    public Article(ArticleVo av) {
        this.title=av.getTitle();
        this.category=av.getCategory();
        this.content=av.getContent();
        this.date=new Date();
    }

    public Article() {

    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
