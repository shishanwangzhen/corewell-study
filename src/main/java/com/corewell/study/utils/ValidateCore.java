package com.corewell.study.utils;

import com.corewell.study.constants.BaseConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2023/03/01/15:28
 * @Description:
 */
public class ValidateCore {

    /**
     * 校验手机号
     *
     * */

    public static boolean verifyPhone(String phone){
        Pattern pattern=Pattern.compile(BaseConstants.REG_PATTERN_PHONE);
        Matcher matcher=pattern.matcher(phone);
        if(matcher.matches()){
            return true;
        }else {
            return false;
        }

    }


    /**
     * 校验手机号
     *
     * */

    public static boolean verifyAccount(String account){
        Pattern pattern=Pattern.compile(BaseConstants.REG_PATTERN_ACCOUNT);
        Matcher matcher=pattern.matcher(account);
        if(matcher.matches()){
            return true;
        }else {
            return false;
        }
    }
}
