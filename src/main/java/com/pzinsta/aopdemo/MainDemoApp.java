package com.pzinsta.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pzinsta.aopdemo.config.DemoConfig;
import com.pzinsta.aopdemo.dao.AccountDAO;
import com.pzinsta.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
        
        accountDAO.addAccount();
        membershipDAO.addAccount();
        membershipDAO.addMember();
        
        context.close();
    }

}
