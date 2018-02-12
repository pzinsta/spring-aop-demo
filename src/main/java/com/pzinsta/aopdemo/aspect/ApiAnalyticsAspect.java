package com.pzinsta.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalyticsAspect {

    @Before("com.pzinsta.aopdemo.aspect.AopExpressions.anyMethodInDaoPackageExcludingGettersAndSetters()")
    public void beforeAddAccountOnAccountDaoAdvice() {
        System.out.println("ApiAnalyticsAspect: Executing @Before advice on AccountDAO.addAccount().");
    }
    
}
