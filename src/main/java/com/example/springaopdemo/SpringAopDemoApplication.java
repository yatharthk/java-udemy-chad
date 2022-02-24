package com.example.springaopdemo;

import com.example.springaopdemo.DAO.AccountDAO;
import com.example.springaopdemo.DAO.MembershipDAO;
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

    //get bean for membership dao
        MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);

        Account account = new Account();
    accountDAO.addAccount(account,true);
        System.out.println("Executing membership \n \n \n");
        membershipDAO.addAccount();
        System.out.println("Executing accountDao again \n \n \n");
        accountDAO.addAccount(account,true);

        System.out.println("Calling the extra added methods ");

        accountDAO.doWork();

        membershipDAO.goToSleep();
    context.close();
}

}
