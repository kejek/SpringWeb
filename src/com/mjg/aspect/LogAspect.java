package com.mjg.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	@Pointcut("@annotation(com.mjg.aspect.Loggable)")
	public void loggableMethods() {
	}

	// Runs before the @Before call, but finishes AFTER the @Before call
	// but finishes before the @After call
	@Around("loggableMethods()")
	public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("log() is running before...");
		System.out.println("***1***");
		Object returnValue = joinPoint.proceed();
		System.out.println("log() is running after...");
		System.out.println("***1***");
		return returnValue;
	}

	// Runs before method is called
	@Before("loggableMethods()")
	public void methodBefore(JoinPoint joinPoint) {
		System.out.println("methodBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("Args : " + obj.toString());
		}
		System.out.println("******");
	}

	// Runs after a method has completed (whether it returned an exception or or
	// not).
	// This runs Before the AfterThrowing and AfterReturning
	@After("loggableMethods()")
	public void methodCleanup(JoinPoint joinPoint) {
		System.out.println("methodCleanup() is running!");
		System.out.println("Cleaning up after : " + joinPoint.getSignature().getName());
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("Args : " + obj.toString());
		}
		System.out.println("******");
	}

	// Runs after a method has successfully returned
	@AfterReturning("loggableMethods()")
	public void methodSuccess(JoinPoint joinPoint) {
		System.out.println("methodSuccess() is running!");
		System.out.println("Successful Run : " + joinPoint.getSignature().getName());
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("Args : " + obj.toString());
		}
		System.out.println("******");
	}

	// Runs only if a method has thrown an exception
	// @AfterThrowing("anyNetflixMethod()")
	@AfterThrowing("loggableMethods()")
	public void methodError(JoinPoint joinPoint) {
		System.out.println("methodError() is running!");
		System.out.println("Error : " + joinPoint.getSignature().getName());
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("Args : " + obj.toString());
		}
		System.out.println("******");
	}

}
