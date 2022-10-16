package com.mustafakaplan.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.mustafakaplan.springbootaop.service.MessageService.showMessage(..))")
    public void beforeShowMessageMethod(JoinPoint joinPoint) {
        System.out.println("Parameter captured before showMessage method - param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.mustafakaplan.springbootaop.service.MessageService.showMessage(..))")
    public void afterShowMessageMethod(JoinPoint joinPoint) {
        System.out.println("Parameter captured after showMessage method - param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
