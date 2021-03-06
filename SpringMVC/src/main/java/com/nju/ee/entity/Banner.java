package com.nju.ee.entity;

import com.nju.ee.vo.BannerVo;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
@Entity
@Table(name = "Banner")
public class Banner {
    private int id;
    private int position;
    private String title;
    @Type(type="text")
    private String brief; //简介
    private String imageUrl;
    private String infoUrl; //banner跳转到的url
    private boolean enabled;

    public Banner() {
    }
    public Banner(BannerVo bannerVo){
        this.position = bannerVo.getPosition();
        this.title = bannerVo.getTitle();
        this.brief = bannerVo.getBrief();
        this.imageUrl = bannerVo.getImageUrl();
        this.infoUrl = bannerVo.getInfoUrl();
        this.enabled = bannerVo.isEnabled();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfoUrl() {
        return infoUrl;
    }

    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
