package com.nju.ee.entity;

import com.nju.ee.vo.PaperVo;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by homer on 16-12-16.
 */
@Entity
@Table(name = "paper")
public class Paper {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    @Type(type="text")
    private String description;

    private String url ;
    private Date date;

    public Paper(){

    }

    public Paper(PaperVo paperVo) {
        this.title = paperVo.getTitle();
        this.description = paperVo.getDesc();
        this.url = paperVo.getUrl();
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            this.date = df.parse(paperVo.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
