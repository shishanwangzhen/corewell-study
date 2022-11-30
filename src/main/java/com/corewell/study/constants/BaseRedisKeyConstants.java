package com.corewell.study.constants;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2022/11/30/9:51
 * @Description:
 */
public class BaseRedisKeyConstants {
    /**
     * Redis普通键前缀
     * */
    public static final String REDIS_KEY_PRE="core:study:access:";

    /**
     * 键
     * */
    public static final String ACCESS_TOKEN_KEY=REDIS_KEY_PRE+"ACCESS_TOKEN";


}
