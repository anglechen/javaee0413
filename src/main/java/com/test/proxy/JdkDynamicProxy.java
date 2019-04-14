/**
 *
 */
package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author aubrey
 * @date  上午9:41:46
 * 
 */
public class JdkDynamicProxy implements InvocationHandler{

	private Object target;
	
	
	public JdkDynamicProxy(Object obj) {
		this.target = obj;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("begin==========");
		long a = System.currentTimeMillis();
		Object result = method.invoke(target, args);
		long b = System.currentTimeMillis();
		
		System.out.println("方法调用耗时：" + (b-a));
		System.out.println("end==========");
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
