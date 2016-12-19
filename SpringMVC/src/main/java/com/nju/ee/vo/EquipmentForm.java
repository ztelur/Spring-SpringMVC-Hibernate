package com.nju.ee.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 张韶阳 on 16/12/14.
 */
public class EquipmentForm {
    String name;
    String description;
    MultipartFile image;

    public EquipmentForm() {
    }

    public EquipmentForm(String name, String description,MultipartFile image) {
        this.name = name;
        this.description = description;
        //this.image=image;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
