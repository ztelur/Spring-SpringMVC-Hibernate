package com.nju.ee.vo;

import java.util.HashMap;

/**
 * Created by 克崽兽 on 2016/12/7.
 */
public class contentType {
    private static HashMap<String,String> extensionContentTypeMap =new HashMap<String, String>(){
        {
            put("jpe","image/jpeg");
            put("jpeg","image/jpeg");
            put("jpg","image/jpeg");
            put("png","image/png");
        }
    };
    public static String extension2ContentType(String extensionName){
        return extensionContentTypeMap.get(extensionName);
    }
}
