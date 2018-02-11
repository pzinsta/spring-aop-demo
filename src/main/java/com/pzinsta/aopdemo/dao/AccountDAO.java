package com.pzinsta.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.pzinsta.aopdemo.model.Account;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println("AccountDAO addAccount() Doing DB work.");
    }
    
    public void addAccount(Account account) {
        System.out.println("AccountDAO addAccount(Account account) Doing DB work.");
    }
    
    public void addAccount(Account account, long someParameter) {
        System.out.println("AccountDAO addAccount(Account account, long someParameter) Doing DB work.");
    }
}
