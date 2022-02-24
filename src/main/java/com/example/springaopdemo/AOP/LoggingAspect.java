package com.example.springaopdemo.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //this is where we add all out advices and logging.

//    ..lets start with an @Before annotation  and advice

//    @Before("execution(public void addAccount())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }


    //wildcard for matching all methods starting with add...
//        @Before("execution(public void add*())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }


    //pointcut expression targeting specific class method.
//    @Before("execution(public void com.example.springaopdemo.DAO.AccountDAO.updateAccount())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }

    //pointcut expression targeting any return type.
//    @Before("execution(public * addAccount())")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }

    //pointcut expression targeting parameter type and any access modifier.
//    @Before("execution(* add*(com.example.springaopdemo.Account))") //specific add* method with parameter type Account
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }

    //pointcut expression targeting any number of parameter after Account type
//    @Before("execution(* add*(com.example.springaopdemo.Account,..))")
//    //specific add* method with parameter type Account followed by any number of arguments
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }

    //pointcut expression targeting any number of parameters
//    @Before("execution(* add*(..))")
//    //specific add* method with parameter type Account followed by any number of arguments
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }

    //point cut expression targeting specific package name . any class .any method inside that class and .. for any params
//    @Before("execution(* com..example.springaopdemo.DAO.*.*(..))")
//    //specific add* method with parameter type Account followed by any number of arguments
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n Executing @Before advice on addAccount()");
//    }

    @Pointcut("execution(* com..example.springaopdemo.DAO.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n Executing @Before advice on addAccount()");
    }
}
