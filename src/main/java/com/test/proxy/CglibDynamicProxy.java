/**
 *
 */
package com.test.proxy;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author aubrey
 * @date  上午10:06:08
 * 
 */
public class CglibDynamicProxy  implements MethodInterceptor{

	
	private Enhancer  enhancer= new Enhancer();
	
	
	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	
	@Override
	public Object intercept(Object obj, Method mthod, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("begin==========");
		long a = System.currentTimeMillis();
		Object result = proxy.invokeSuper(obj, args);
		long b = System.currentTimeMillis();
		
		System.out.println("方法调用耗时：" + (b-a));
		System.out.println("end==========");
		return result;
	}
	

}
