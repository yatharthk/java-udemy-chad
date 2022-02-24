package com.example.springaopdemo.DAO;

import com.example.springaopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account,boolean vip){
        System.out.println(this.getClass()+" : Adding Account");
    }

    public boolean doWork(){
        System.out.println(this.getClass()+" doWork()");
        return false;
    }
}
