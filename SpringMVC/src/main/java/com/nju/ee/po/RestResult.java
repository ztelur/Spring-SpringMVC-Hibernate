package com.nju.ee.po;

/**
 * Created by 克崽兽 on 2016/12/2.
 */
public class RestResult {
    private int result;
    private Object data;
    private Error error;

    public Error getError(){
        return error;
    }
    public int getResult(){
        return result;
    }
    public Object getData(){
        return data;
    }

    /**
     *
     * @param result 1表示正常，其它均表示出错
     * @param data
     */
    public RestResult(int result, Object data){
        this.result = result;
        if(result == 1){
            this.data = data;
        }else{
            this.error = (Error) data;
        }
    }
    public static RestResult CreateResult(int result, Object data){
        return new RestResult(result,data);
    }
}
