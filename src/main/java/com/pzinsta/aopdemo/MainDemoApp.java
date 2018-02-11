package com.pzinsta.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pzinsta.aopdemo.config.DemoConfig;
import com.pzinsta.aopdemo.dao.AccountDAO;

public class MainDemoApp {

    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        
        AccountDAO accountDAO = context.getBean(AccountDAO.class);
        
        accountDAO.addAccount();
        
        context.close();
    }

}
