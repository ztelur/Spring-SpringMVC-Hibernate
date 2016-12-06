package com.nju.ee.po;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public class Error {
    public static final String FORBIDDEN = "403";
    public static final String NOT_AUTH = "401";
    public static final String BAD_PARAM = "402";
    public static final String SYS_ERROR = "405";
    private String code;
    public Error(String code,String message){
        this.code= code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String message;
}
