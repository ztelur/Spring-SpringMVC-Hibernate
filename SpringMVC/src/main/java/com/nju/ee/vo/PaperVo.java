package com.nju.ee.vo;

/**
 * Created by homer on 16-12-16.
 */

import com.nju.ee.entity.Paper;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 论文页面的VO
 */
public class PaperVo {
    private int id;
    private String title;
    private String desc;
    private String url ;
    private String date;
    private MultipartFile pdf;

    public PaperVo(){

    }
    public PaperVo(Paper paper) {
        this.id = paper.getId();
        this.title = paper.getTitle();
        this.desc = paper.getDescription();
        this.url = paper.getUrl();
        this.date =  new SimpleDateFormat("yyyy-MM-dd").format(paper.getDate());
    }


    public MultipartFile getPdf() {
        return pdf;
    }

    public void setPdf(MultipartFile pdf) {
        this.pdf = pdf;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
