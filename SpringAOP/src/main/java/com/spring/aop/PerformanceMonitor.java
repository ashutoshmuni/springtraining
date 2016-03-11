package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformanceMonitor {
	
	long startTime = 0;
	
	@Pointcut("execution(* CollectionHandler.addElementsIn*(..))")
	public void pc() {}

	
	@Around("pc()")
	public void monitorPerformance(ProceedingJoinPoint pjp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long endTime = System.currentTimeMillis();
		System.out.println("obj = " + obj);
		System.out.println("Time required: " + (endTime - startTime));
	}
	
	@AfterThrowing(  
            pointcut = "execution(* CollectionHandler.addElementsIn*(..))",  
            throwing= "error")  
              
  public void myadvice(JoinPoint jp,Throwable error)//it is advice  
  {  
      System.out.println("additional concern");  
      System.out.println("Method Signature: "  + jp.getSignature());  
      System.out.println("Exception is: "+error);  
      System.out.println("end of after throwing advice...");  
  }  	
	//@Before("pc()")
	public void logStartTime() {
		startTime = System.currentTimeMillis();
		System.out.println("start time : " + startTime);
	}
	
	//@After("pc()")
	public void logTimeRequired(JoinPoint jp) {
		System.out.println("Time required for " + jp.getSignature() + " method is " + (System.currentTimeMillis() - startTime));
	}
}
