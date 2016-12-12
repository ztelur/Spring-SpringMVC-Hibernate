package com.nju.ee.Constant;

import java.util.HashMap;

/**
 * Created by 克崽兽 on 2016/12/7.
 */
public class Extension {
    private static HashMap<String,String> extensionContentTypeMap =new HashMap<String, String>(){
        {
            put("jpe","image/jpeg");
            put("jpeg","image/jpeg");
            put("jpg","image/jpeg");
            put("png","image/png");
            put("pdf","application/pdf");
        }
    };
    private static HashMap<String,FileType> extensionFileTypeMap =new HashMap<String, FileType>(){
        {
            put("jpe",FileType.IMAGE);
            put("jpeg",FileType.IMAGE);
            put("jpg",FileType.IMAGE);
            put("png",FileType.IMAGE);
            put("application/pdf",FileType.PDF);
        }
    };
    public static String extension2ContentType(String extensionName){
        return extensionContentTypeMap.get(extensionName);
    }

    public static FileType extension2FileType(String extensionName) {
        FileType ft =  extensionFileTypeMap.get(extensionName);
        if(ft==null){
            ft = FileType.DEFAULT;
        }
        return ft;
    }
}
