package com.mjg.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NetflixAspect {
	@Pointcut("execution(* com.mjg.controller.rest.NetflixController.*(..))")
	public void anyNetflixMethod()
		{
		}
	@Before("anyNetflixMethod()")
	public void logNetflixMethod(){
		System.out.println("Called a netflix method");
		
	}

}
