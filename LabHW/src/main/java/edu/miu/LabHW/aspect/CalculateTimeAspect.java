package edu.miu.LabHW.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculateTimeAspect {

   // @Pointcut("execution(* edu.miu.LabHW.controller.UserController.*(..))")
    @Pointcut("execution(java.util.List edu.miu.LabHW.entity.dto.UsersDTO.*(..))")
    public void logPointcut() {
    }
    @After(value = "logPointcut()")
    public void logAfterReturning(JoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
    }
   /* @Around("logPointcut()")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = point.proceed();
        long endtime = System.currentTimeMillis();
        System.out.println("Class Name: " + point.getSignature().getDeclaringTypeName() + ". Method Name: " + point.getSignature().getName() + ". Time taken for Execution is : " + (endtime - startTime) + "ms");
        return object;
    }*/


    /* @Pointcut("execution(* edu.miu.LabHW.controller.UserController.*(..))")
    public void logPointcut() {
    }


    @AfterReturning(value = "logPointcut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, UsersDTO result) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
    }*/

}
