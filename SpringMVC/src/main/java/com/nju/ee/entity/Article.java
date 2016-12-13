package com.nju.ee.entity;

import com.nju.ee.vo.ArticleVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.Date;

/**
 * Created by homer on 16-10-31.
 */
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String category;
    private Blob content;
    private Date date;

//    @ManyToOne(targetEntity = Person.class)
//    @JoinColumn(name = "person_id",referencedColumnName = "id",nullable = false)
//    private Person person;


    public Article(ArticleVo av) {
        try {
            this.title = av.getTitle();
            this.category = av.getCategory();
//            byte[] buff = av.getContent().getBytes(); 
            byte[] buff = av.getContent().getBytes();
            this.content = new SerialBlob(buff);
            this.date = new Date();

        } catch (Exception e) {
            e.printStackTrace();
        }
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

        try {
//         byte[] data = content.getBytes(1, (int) content.length());
            byte[] data = content.getBytes(1, (int) content.length());
            String s = new String(data);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setContent(String content) {

//        try { byte[] buff = content.getBytes(); this.content = new SerialBlob(buff); } catch (Exception e) { 
//            e.printStackTrace(); }
        try {
            byte[] buff = content.getBytes();
            this.content = new SerialBlob(buff);

        } catch
                (Exception e) {
            e.printStackTrace();
        }
        return;
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
