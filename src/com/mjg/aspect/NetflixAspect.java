package com.mjg.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NetflixAspect {
	@Pointcut("execution(* com.mjg.controller.rest.NetflixController.*(..))")
	public void anyNetflixMethod() {
	}

	@Before("anyNetflixMethod()")
	public void logNetflixMethod(JoinPoint joinPoint) {
		System.out.println("logNetflixMethod() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("Args : " + obj.toString());
		}
		System.out.println("******");
	}
	
	@AfterReturning("anyNetflixMethod()")
	public void logNetflixSuccess(JoinPoint joinPoint) {
		System.out.println("logNetflixSuccess() is running!");
		System.out.println("Successful Run : " + joinPoint.getSignature().getName());
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("Args : " + obj.toString());
		}
		System.out.println("******");
	}

	@AfterThrowing("anyNetflixMethod()")
	public void logNetflixError(JoinPoint joinPoint) {
		System.out.println("logNetflixError() is running!");
		System.out.println("Error : " + joinPoint.getSignature().getName());
		for (Object obj : joinPoint.getArgs()) {
			System.out.println("Args : " + obj.toString());
		}
		System.out.println("******");
	}

}
