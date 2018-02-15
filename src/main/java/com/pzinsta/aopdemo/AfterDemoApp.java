package com.pzinsta.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pzinsta.aopdemo.config.DemoConfig;
import com.pzinsta.aopdemo.dao.AccountDAO;
import com.pzinsta.aopdemo.model.Account;

public class AfterDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        try {
            List<Account> accounts = accountDAO.findAccountsThrowingException();
            accounts.stream().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e);
        }
        
        accountDAO.findAccounts();

        context.close();
    }

}
