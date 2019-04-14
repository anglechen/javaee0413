/**
 *
 */
package com.test.proxy2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.test.proxy.CglibDynamicProxy;
import com.test.web.dao.UserDao;
import com.test.web.dao.impl.UserDaoImpl2;
import com.test.web.model.User;

/**
 * @author aubrey
 * @date  上午10:12:39
 * 
 */
public class CglibDynamicProxyTest {

	@Test
	public void test() {
		CglibDynamicProxy cglibProxy = new CglibDynamicProxy();
		
		UserDao userDao = (UserDao) cglibProxy.getProxy(UserDaoImpl2.class);
		
		
		userDao.insert(new User());
		userDao.update(new User());
		
		
		
		
		
	}

}
