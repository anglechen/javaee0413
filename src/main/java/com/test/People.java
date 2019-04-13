/**
 *
 */
package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author aubrey
 * @date  上午10:57:54
 * 
 */

@Component("p8")
public class People {
	private String name;
	
	private Integer age;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public People() {
		System.out.println("构造函数");
	}
	
	public People(String name ,int age) {
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//设值注入
		People p1 = new People();
		p1.setName("李四");
		p1.setAge(23);
		//构造器注入
		People p2 = new People("张三",22);
		
		//类加载器
//		p1.getClass()
		System.out.println(People.class.getClassLoader());
		System.out.println(People.class.getClassLoader().getParent());
		System.out.println(People.class.getClassLoader().getParent().getParent());
	
		Class clazz = People.class;
		Constructor[] constructor = clazz.getConstructors();
		Constructor constructorNull = clazz.getConstructor(null);
		People p3 = (People) constructorNull.newInstance(null);
		p3.setAge(33);
		System.out.println("p3age:" + p3.getAge());
	
		//spring bean
		BeanFactory application 
		= new ClassPathXmlApplicationContext("application.xml");
		People p4 = (People) application.getBean("p8");
		People p9 = application.getBean(People.class);
		p4.setAge(100);
		System.out.println("p8 ===" + p4);
		System.out.println("p9===" + p9 + ":" + p9.getAge());
		People p5 = new People();
		
		
//		@Autowired
//		@Qualifier("people1")
//		@Resource("id")
//		private People p8;
		
		
		p4.setName("test");
		System.out.println("spring p4" + p4.getName());
	}
	
	
	

}
