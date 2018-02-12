package com.pzinsta.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.pzinsta.aopdemo.model.Account;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;
    
    public void addAccount() {
        System.out.println("AccountDAO addAccount() Doing DB work.");
    }
    
    public void addAccount(Account account) {
        System.out.println("AccountDAO addAccount(Account account) Doing DB work.");
    }
    
    public void addAccount(Account account, long someParameter) {
        System.out.println("AccountDAO addAccount(Account account, long someParameter) Doing DB work.");
    }

    public String getServiceCode() {
        System.out.println("AccountDAO.getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("AccountDAO.setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public String getName() {
        System.out.println("AccountDAO.getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("AccountDAO.setName()");
        this.name = name;
    }
}
