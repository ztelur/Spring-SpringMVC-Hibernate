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
        int wordsIgnored=0;
        EPlatform ePlatform = OSInfo.getOSName();
        switch (ePlatform){
            case Linux:
                wordsIgnored = 5;
                break;
            case Windows:
                wordsIgnored = 6;
                break;
            case Mac_OS:
                wordsIgnored = 5;
                break;
        }
        classPath = classPath.substring(wordsIgnored);//略过“file:/”
        classPath = classPath.replaceAll("%20"," ");
        try ( FileInputStream in = new FileInputStream(classPath+"META-INF/properties/"+propertiesPath)){
            pro.load(in);
            in.close();
        }catch (IOException e){
            return null;
        }
        return pro;
    }

    public static String getFileRootProperty(){
        EPlatform ePlatform = OSInfo.getOSName();
        String fileRootProperty="";
        switch (ePlatform){
            case Linux:
                fileRootProperty = "linuxFileRoot";
                break;
            case Windows:
                fileRootProperty = "windowsFileRoot";
                break;
            case Mac_OS:
                fileRootProperty = "iosFileRoot";
                break;
        }
        return fileRootProperty;
    }
}
