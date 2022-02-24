package com.example.springaopdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void  addAccount(){
        System.out.println(this.getClass()+"Doing stuff adding  membership account");
    }

    public void goToSleep(){
        System.out.println(this.getClass() +" I am going to sleep now...");
    }
}
