package com.pzinsta.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Pointcut("execution(* com.pzinsta.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}
    
    @Pointcut("execution(* com.pzinsta.aopdemo.dao.*.get*(..))")
    private void getterInDaoPackage() {}
    
    @Pointcut("execution(* com.pzinsta.aopdemo.dao.*.set*(..))")
    private void setterInDaoPackage() {}
    
    @Pointcut("forDaoPackage() && !(getterInDaoPackage() || setterInDaoPackage())")
    private void anyMethodInDaoPackageExcludingGettersAndSetters() {}
    
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
    
    @Before("execution(* add*(..))")
    public void beforeAnyMethodThatStartsWithAddAndTakesAnyNumberOfParametersAdvice() {
        System.out.println("Executing @Before advice on a method that starts with 'add' and takes any number of parameters.");
    }
    
    @Before("execution(* com.pzinsta.aopdemo.dao.*.*(..))")
    public void beforeAnyMethodWithAnyParametersInAnyClassInSpecifiedPackageAdvice() {
        System.out.println("Executing @Before advice on a method with any number and types of parameters in any class in the com.pzinsta.aopdemo.dao package.");
    }
    
    @Before("forDaoPackage()")
    public void beforeAnyMethodWithAnyParametersInAnyClassInSpecifiedPackageUsingPointcutDeclarationAdvice() {
        System.out.println("Executing @Before advice on a method with any number and types of parameters in any class in the com.pzinsta.aopdemo.dao package using @Pointcut declaration.");
    }
    
    @Before("anyMethodInDaoPackageExcludingGettersAndSetters()")
    public void beforeAnyMethodWithAnyParametersInAnyClassInSpecifiedPackageExcludingGettersAndSettersAdvice() {
        System.out.println("Executing @Before advice on a method with any number and types of parameters in any class in the com.pzinsta.aopdemo.dao package excluding getters and setters.");
    }
}
