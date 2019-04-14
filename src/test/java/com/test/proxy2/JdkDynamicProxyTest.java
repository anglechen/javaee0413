/**
 *
 */
package com.test.proxy2;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.test.proxy.JdkDynamicProxy;
import com.test.web.dao.UserDao;
import com.test.web.dao.impl.UserDaoImpl2;
import com.test.web.model.User;

/**
 * @author aubrey
 * @date  上午9:49:51
 * 
 */
public class JdkDynamicProxyTest {
	
	@Test
	public void testInvoke() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("类加载器：" + UserDao.class.getClassLoader());
//		Class clazz = Proxy.getProxyClass(UserDao.class.getClassLoader(), UserDao.class);
//		Constructor constructor = clazz.getConstructor(InvocationHandler.class);
//		UserDao userDao = (UserDao) constructor.newInstance(new JdkDynamicProxy(new UserDaoImpl2()));
//		
		UserDao userDao = (UserDao)Proxy.newProxyInstance(UserDao.class.getClassLoader(),
				new Class[] {UserDao.class},
				new JdkDynamicProxy(new UserDaoImpl2()));
		
		System.out.println(userDao);
		User user = new User();
		userDao.insert(user);
		userDao.update(user);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
