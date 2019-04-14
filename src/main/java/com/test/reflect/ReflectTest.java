/**
 *
 */
package com.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.test.web.dao.impl.UserDaoImpl2;
import com.test.web.model.User;

/**
 * @author aubrey
 * @date  上午10:48:00
 * 
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		
		
		
		Class clazz = UserDaoImpl2.class;
		Class clazz2 = new UserDaoImpl2().getClass();
		Class clazz3 = ReflectTest.class.getClassLoader().loadClass("com.test.web.dao.impl.UserDaoImpl2");
		
		System.out.println("=====属性=======");
		Field[] fields = clazz.getFields();
		Field[] fields2 = clazz.getDeclaredFields();
		for(Field f : fields) {
			System.out.println("name:" + f.getName() + ";type:" + f.getType());
		}
		System.out.println("====declared=====");
		for(Field f : fields2) {
			System.out.println("name:" + f.getName() + ";type:" + f.getType());
		}
		
		System.out.println("=====方法=======");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods) {
			System.out.println(m.getName());
		}
		Method method = clazz.getDeclaredMethod("insert", User.class);
		UserDaoImpl2 userDao2 = (UserDaoImpl2) clazz.newInstance();
		System.out.println("==invoke:======");
		method.invoke(userDao2,new User());
//		userDao2.insert(new User());
		
		System.out.println("结束");
		
		
		
		
		
	}
}
