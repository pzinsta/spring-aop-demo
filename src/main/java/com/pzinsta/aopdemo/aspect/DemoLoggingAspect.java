package com.pzinsta.aopdemo.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.pzinsta.aopdemo.model.Account;

@Aspect
@Component
@Order(3)
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
        System.out.println(
                "Executing @Before advice on a method that starts with 'add' and takes an Account as a parameter.");
    }

    @Before("execution(* add*(com.pzinsta.aopdemo.model.Account, ..))")
    public void beforeAnyMethodThatStartsWithAddAndTakesAccountParameterFolledByAnyNumberOfParametersAdvice() {
        System.out.println(
                "Executing @Before advice on a method that starts with 'add' and takes an Account as a parameter followed by any number of parameters.");
    }

    @Before("execution(* add*(..))")
    public void beforeAnyMethodThatStartsWithAddAndTakesAnyNumberOfParametersAdvice() {
        System.out.println(
                "Executing @Before advice on a method that starts with 'add' and takes any number of parameters.");
    }

    @Before("execution(* com.pzinsta.aopdemo.dao.*.*(..))")
    public void beforeAnyMethodWithAnyParametersInAnyClassInSpecifiedPackageAdvice() {
        System.out.println(
                "Executing @Before advice on a method with any number and types of parameters in any class in the com.pzinsta.aopdemo.dao package.");
    }

    @Before("com.pzinsta.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAnyMethodWithAnyParametersInAnyClassInSpecifiedPackageUsingPointcutDeclarationAdvice() {
        System.out.println(
                "Executing @Before advice on a method with any number and types of parameters in any class in the com.pzinsta.aopdemo.dao package using @Pointcut declaration.");
    }

    @Before("com.pzinsta.aopdemo.aspect.AopExpressions.anyMethodInDaoPackageExcludingGettersAndSetters()")
    public void beforeAnyMethodWithAnyParametersInAnyClassInSpecifiedPackageExcludingGettersAndSettersAdvice() {
        System.out.println(
                "Executing @Before advice on a method with any number and types of parameters in any class in the com.pzinsta.aopdemo.dao package excluding getters and setters.");
    }

    @Before("com.pzinsta.aopdemo.aspect.AopExpressions.anyMethodInDaoPackageExcludingGettersAndSetters()")
    public void displayMethodSignatureBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Method: " + joinPoint.getSignature());

        System.out.println("Arguments: ");
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
    }

    @AfterReturning(pointcut = "execution(* com.pzinsta.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("Executing @AfterReturning advice on " + joinPoint.getSignature().toShortString());
        
        System.out.println("Result is " + result);
        
        convertNamesToUpperCase(result);
    }

    private void convertNamesToUpperCase(List<Account> result) {
        result.stream().forEach(account -> account.setName(account.getName().toUpperCase()));
    }
    
    @AfterThrowing(pointcut = "execution(* com.pzinsta.aopdemo.dao.AccountDAO.findAccountsThrowingException(..))", throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Executing @AfterThrowing advice on " + joinPoint.getSignature().toShortString());
        
        System.out.println("The exception is: " + exception);
        
    }
    
}
