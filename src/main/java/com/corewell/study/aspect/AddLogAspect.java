package com.corewell.study.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: wangzhen
 * @Date: 2023/02/25/11:29
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class AddLogAspect {


    @Pointcut("@annotation(com.corewell.study.annotation.AddLog)")
    public void addLogCut() {

    }

    @Before(value = "addLogCut()")
    public Object before(JoinPoint point){
        return null;
    }
}
