package com.pzinsta.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println("AccountDAO addAccount() Doing DB work.");
    }
}
