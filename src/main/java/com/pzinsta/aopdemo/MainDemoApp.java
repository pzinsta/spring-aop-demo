package com.pzinsta.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pzinsta.aopdemo.config.DemoConfig;
import com.pzinsta.aopdemo.dao.AccountDAO;
import com.pzinsta.aopdemo.dao.MembershipDAO;
import com.pzinsta.aopdemo.model.Account;

public class MainDemoApp {

    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean(MembershipDAO.class);
        
        accountDAO.addAccount();
        membershipDAO.addAccount();
        membershipDAO.addMember();
        
        Account account = new Account();
        accountDAO.addAccount(account);
        
        accountDAO.addAccount(account, 0);
        
        context.close();
    }

}
