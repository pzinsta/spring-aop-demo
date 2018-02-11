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
    
    @Before("execution(public void add*())")
    public void beforeAnyMethodThatStartsWithAddAdvice() {
        System.out.println("Executing @Before advice on a method that starts with 'add'.");
    }
    
    @Before("execution(* add*(com.pzinsta.aopdemo.model.Account))")
    public void beforeAnyMethodThatStartsWithAddAndTakesAccountParameterAdvice() {
        System.out.println("Executing @Before advice on a method that starts with 'add' and takes an Account as a parameter.");
    }
    
    @Before("execution(* add*(com.pzinsta.aopdemo.model.Account, ..))")
    public void beforeAnyMethodThatStartsWithAddAndTakesAccountParameterFolledByAnyNumberOfParametersAdvice() {
        System.out.println("Executing @Before advice on a method that starts with 'add' and takes an Account as a parameter followed by any number of parameters.");
    }

}
