/**
 *
 */
package com.test.other;

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

/**
 * @author aubrey
 * @date  下午4:13:55
 * 自定义注解配置
 */
//@Component
//@Aspect
public class ResultAspect {
	
//	@Pointcut("execution(* com.test.controller.*.*(..))")
//	@Pointcut("@annotation(com.test.web.aop.LogAnnotation)")
	public void logtest() {};
	
	@Before("logtest()")
	public void before(JoinPoint joinPint) {
/*//		joinPint.getSignature()
*/		System.out.println("aspect开始执行方法：================");
	}
	
	@After("logtest()")
	public void after() {
		System.out.println("aspect结束执行方法：================");
	}
	
	@Around("logtest()")
	public Object arround(ProceedingJoinPoint pjp) throws Throwable {
		long a = System.currentTimeMillis();
		Object obj = null;
		OutputJson out = null;
		try {
			obj = pjp.proceed();//执行真正的方法
			out = new OutputJson(200, "success", obj);
		}catch (Exception e) {
			out = new OutputJson(500, e.getMessage(), obj);
		}
		
		long b = System.currentTimeMillis();
		System.out.println("方法执行时间：" + (b-a));
		
		return out.toString();
		
	}
	
	@AfterThrowing(pointcut="logtest()",throwing="e")
	public void afterThrowing(JoinPoint  pjp, Throwable e) throws Throwable {
		OutputJson out = new OutputJson(500, e.getMessage(), "");
		System.out.println(out.toString());
		
	}
	
	@AfterReturning(pointcut="logtest()" , returning="result")
	public Object afterReturning(JoinPoint pj,Object result) throws Throwable {
		System.out.println("afterreturing..........");
		OutputJson out = new OutputJson(200, "success", result);
		return out.toString();
		
	}
	
	
	
	
	
	
	
	
	

}
