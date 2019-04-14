/**
 *
 */
package com.test.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
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
@Component
@Aspect
public class LogAspect {
	
//	@Pointcut("execution(public com.test.web.dao.impl.User*.set*(..) )")
	@Pointcut("@annotation(com.test.web.aop.LogAnnotation)")
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
		
		Object obj = pjp.proceed();//执行真正的方法
		
		
		long b = System.currentTimeMillis();
		System.out.println("方法执行时间：" + (b-a));
		
		return obj;
		
	}
	
	
	
	
	
	
	
	
	

}
