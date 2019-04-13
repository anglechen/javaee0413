/**
 *
 */
package com.test.web.aop;

import org.springframework.stereotype.Component;

/**
 * @author aubrey
 * @date  下午3:54:11
 * 配合xml配置的通知
 */
@Component("logAdvice")
public class Log {
	
	public void before() {
		System.out.println("开始执行方法：================");
	}
	
	public void after() {
		System.out.println("结束执行方法：================");
	}
	
}
