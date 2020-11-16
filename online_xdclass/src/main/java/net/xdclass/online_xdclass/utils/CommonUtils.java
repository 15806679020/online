package net.xdclass.online_xdclass.utils;

import java.security.MessageDigest;

/**
 * @ClassName CommonUtils
 * @Description TODO 公共工具类
 * @Author LD
 * @Date 2020/8/20 17:45
 * @Version 1.0
 **/
public class CommonUtils {
    /**
     * @Description: MD5加密
     * @Author: LD
     * @Date: 2020/8/20 17:45
     * @param data: 需要加密的数据
     * @return: java.lang.String
     **/
    public static String MD5(String data) {
        try {
            java.security.MessageDigest md =
                    MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
