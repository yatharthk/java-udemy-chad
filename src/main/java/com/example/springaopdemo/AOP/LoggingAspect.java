package com.example.springaopdemo.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //this is where we add all out advices and logging.

//    ..lets start with an @Before annotation  and advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n Executing @Before advice on addAccount()");
    }


}
