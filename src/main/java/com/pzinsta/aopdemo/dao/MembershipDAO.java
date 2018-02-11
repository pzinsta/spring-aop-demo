package com.pzinsta.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println("MembershipDAO addAccount() doing work.");
    }
    
    public void addMember() {
        System.out.println("MembershipDAO addMember() doing work.");
    }
}
