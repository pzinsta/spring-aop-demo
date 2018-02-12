package com.pzinsta.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLoggingAspect {

    @Before("com.pzinsta.aopdemo.aspect.AopExpressions.anyMethodInDaoPackageExcludingGettersAndSetters()")
    public void beforeAddAccountOnAccountDaoAdvice() {
        System.out.println("CloudLoggingAspect: Executing @Before advice.");
    }
    
}
