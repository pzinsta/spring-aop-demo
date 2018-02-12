package com.pzinsta.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    
    @Pointcut("execution(* com.pzinsta.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}
    
    @Pointcut("execution(* com.pzinsta.aopdemo.dao.*.get*(..))")
    public void getterInDaoPackage() {}
    
    @Pointcut("execution(* com.pzinsta.aopdemo.dao.*.set*(..))")
    public void setterInDaoPackage() {}
    
    @Pointcut("forDaoPackage() && !(getterInDaoPackage() || setterInDaoPackage())")
    public void anyMethodInDaoPackageExcludingGettersAndSetters() {}
    
}
