package com.example.springaopdemo;

import com.example.springaopdemo.DAO.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class SpringAopDemoApplication {

    public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

    AccountDAO accountDAO= context.getBean("accountDAO",AccountDAO.class);

    accountDAO.addAccount();
        System.out.println("Executing again \n \n \n");
        accountDAO.addAccount();
    context.close();
}

}
