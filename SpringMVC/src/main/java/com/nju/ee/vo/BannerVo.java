package com.nju.ee.vo;

import com.nju.ee.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
public class BannerVo {
    private Integer id;
    private Integer position;
    private String title;
    private String brief;//简介
    private String imageUrl;
    private MultipartFile picture;
    private String infoUrl; //banner跳转到的url
    private boolean enabled;

    public BannerVo() {
    }

    public BannerVo(Banner banner) {
        this.id = banner.getId();
        this.position = banner.getPosition();
        this.title = banner.getTitle();
        this.brief = banner.getBrief();
        this.imageUrl = banner.getImageUrl();
        this.infoUrl = banner.getInfoUrl();
        this.enabled = banner.isEnabled();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
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
