package com.pzinsta.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice on addAccount().");
    }
    
    @Before("execution(public void com.pzinsta.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountOnAccountDaoAdvice() {
        System.out.println("Executing @Before advice on AccountDAO.addAccount().");
    }
}
