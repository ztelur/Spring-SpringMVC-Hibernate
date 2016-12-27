package com.nju.ee.vo;

import com.nju.ee.entity.OtherInfo;

/**
 * Created by zangxiaojie on 2016/12/20.
 */
public class OtherInfoVo {
    private int id;
    private String email;
    private String telephone;
    private String fax;
    private double longitude;
    private double latitude;

    public OtherInfoVo(){

    }
    public OtherInfoVo(OtherInfo otherInfo){
        this.id=otherInfo.getId();
        this.email=otherInfo.getEmail();
        this.telephone=otherInfo.getTelephone();
        this.fax=otherInfo.getFax();
        this.longitude=otherInfo.getLongitude();
        this.latitude=otherInfo.getLatitude();

    }
    public OtherInfoVo(String email, String telephone,String fax,double longitude, double latitude) {
        this.email = email;
        this.telephone=telephone;
        this.fax=fax;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
