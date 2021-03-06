package com.nju.ee.entity;

import com.nju.ee.vo.OtherInfoVo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zangxiaojie on 2016/12/20.
 */
@Entity
@Table(name="otherInfo")
public class OtherInfo {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String telephone;
    private String fax;
    private double longitude;
    private double latitude;

    public OtherInfo(){

    }
    public OtherInfo(String email, String telephone,String fax,double longitude, double latitude) {
        this.email = email;
        this.longitude = longitude;
        this.latitude = latitude;
        this.telephone=telephone;
        this.fax=fax;

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
