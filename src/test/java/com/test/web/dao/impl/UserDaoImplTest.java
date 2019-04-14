/**
 *
 */
package com.test.web.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.web.dao.UserDao;
import com.test.web.model.User;

/**
 * @author aubrey
 * @date  下午3:00:48
 * 
 */

public class UserDaoImplTest {

	@Test
	public void testInsert() {
		BeanFactory beanFactory = 
				new ClassPathXmlApplicationContext("application.xml");
		UserDao userDao = (UserDao) beanFactory.getBean("userDaoImpl");
//		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setName("张三");
		user.setPassword("123456");
		System.out.println(beanFactory.getBean("userDaoImpl"));
		System.out.println("=========insert=============");
		userDao.insert(user);
		
		System.out.println("=========update=============");
		userDao.update(user);
	}

	/**
	 * Test method for {@link com.test.web.dao.impl.UserDaoImpl#update(com.test.web.model.User)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.test.web.dao.impl.UserDaoImpl#del(com.test.web.model.User)}.
	 */
	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.test.web.dao.impl.UserDaoImpl#query(com.test.web.model.User)}.
	 */
	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

}
