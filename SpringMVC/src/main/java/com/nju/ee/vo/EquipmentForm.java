package com.nju.ee.vo;

/**
 * Created by 张韶阳 on 16/12/14.
 */
public class EquipmentForm {
    String name;
    String description;

    public EquipmentForm() {
    }

    public EquipmentForm(String name, String description) {
        this.name = name;
        this.description = description;
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
}
