package com.nju.ee.Constant;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
public enum EPlatform {
    Linux("Linux"),
    Windows("Windows"),
    Mac_OS("Mac OS");
    private EPlatform(String desc){
        this.description = desc;
    }
    public String toString(){
        return description;
    }
    private String description;
}
