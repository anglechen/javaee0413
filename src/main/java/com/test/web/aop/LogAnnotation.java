/**
 *
 */
package com.test.web.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author aubrey
 * @date  下午4:18:43
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
	
	
	 public String value() default "";
	 
	 public String name() default "test";

	 
	 
	 
	 
	 
}
