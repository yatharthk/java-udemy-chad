package com.example.springaopdemo.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.springaopdemo.DAO.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.example.springaopdemo.DAO.*.get*(..))")
    private void forGetters(){}

    @Pointcut("execution(* com.example.springaopdemo.DAO.*.set*(..))")
    private void forSetters(){}

    @Pointcut("forDaoPackage() && !(forGetters() || forSetters()")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalysis(){
        System.out.println("\n Performing Api analysis");
    }

}
