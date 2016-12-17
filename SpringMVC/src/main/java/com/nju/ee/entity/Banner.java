package com.nju.ee.entity;

import com.nju.ee.vo.BannerVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
@Entity
@Table(name = "Banner")
public class Banner {
    @Id
    @GeneratedValue
    private int position;
    private String brief; //简介
    private String imageUrl;
    private String infoUrl; //banner跳转到的url
    private boolean enabled;

    public Banner() {
    }
    public Banner(BannerVo bannerVo){
        this.brief = bannerVo.getBrief();
        this.imageUrl = bannerVo.getImageUrl();
        this.infoUrl = bannerVo.getInfoUrl();
        this.enabled = bannerVo.isEnabled();
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
