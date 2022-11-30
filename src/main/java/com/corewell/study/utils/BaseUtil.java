package com.corewell.study.utils;

import java.util.Base64;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/18/11:21
 * @Description:
 */
public class BaseUtil {
    private static final String CLIENT_ID="4b8420d4dc974fd48285086d09022f9b";
    private static final String SECRET="c9b3dcb0d671414a86286fd2d3f0c67b";
    /**
     * BASE64加密
     * */
    public static String encodedString(){
        String originalInput = CLIENT_ID+":"+SECRET;
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println(encodedString);
        return encodedString;
    }

    public static void main(String[] args) {
        System.out.println(encodedString());
    }
}
