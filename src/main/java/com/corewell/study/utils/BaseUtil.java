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
    private static final String CLIENT_ID="621d35860cce451a886b9329affb52c6";
    private static final String SECRET="394009ab6f414c14a7e62f9fddf9369b";
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
