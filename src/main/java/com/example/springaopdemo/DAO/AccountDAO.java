package com.example.springaopdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(){
        System.out.println(this.getClass()+" : Adding Account");
    }
}
