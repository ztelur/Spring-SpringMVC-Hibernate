package com.nju.ee.Constant;

/**
 * Created by 克崽兽 on 2016/12/16.
 */
public class OSInfo {
    private static String OS = System.getProperty("os.name").toLowerCase();

    private static OSInfo _instance = new OSInfo();

    private EPlatform platform;

    private OSInfo(){}

    public static boolean isLinux(){
        return OS.indexOf("linux")>=0;
    }

    public static boolean isMacOS(){
        return OS.indexOf("mac")>=0;
    }


    public static boolean isWindows(){
        return OS.indexOf("windows")>=0;
    }

    /**
     * 获取操作系统名字
     * @return 操作系统名
     */
    public static EPlatform getOSName(){
       if (isLinux()) {
            _instance.platform = EPlatform.Linux;
        }else if (isMacOS()) {
            _instance.platform = EPlatform.Mac_OS;
        }else if (isWindows()) {
            _instance.platform = EPlatform.Windows;
        }
        return _instance.platform;
    }
}
