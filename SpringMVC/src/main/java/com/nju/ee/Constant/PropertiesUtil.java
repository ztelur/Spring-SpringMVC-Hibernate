package com.nju.ee.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 克崽兽 on 2016/12/12.
 */
public class PropertiesUtil {
    public static Properties getProperties(String propertiesPath){
        Properties pro = new Properties();
        String classPath = PropertiesUtil.class.getResource("/").toString();
        classPath = classPath.substring(6);//略过“file:/”
        classPath = classPath.replaceAll("%20"," ");
        try ( FileInputStream in = new FileInputStream(classPath+"META-INF/properties/"+propertiesPath)){
            pro.load(in);
            in.close();
        }catch (IOException e){
            return null;
        }
        return pro;
    }
}
