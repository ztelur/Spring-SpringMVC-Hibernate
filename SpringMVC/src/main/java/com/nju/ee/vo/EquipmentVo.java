package com.nju.ee.vo;

/**
 * Created by homer on 16-10-31.
 */
public class EquipmentVo {
    private int id;
    private String name;
    private String description;
    private String url;
    public EquipmentVo() {
    }

    public EquipmentVo(int id, String name, String description,String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url=url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
