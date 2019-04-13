/**
 *
 */
package com.test.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
	
//	@Pointcut("execution(* com.test.web.dao.impl.UserDaoImpl.*(..) )")
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

}
