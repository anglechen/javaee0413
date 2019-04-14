/**
 *
 */
package com.test.web.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.web.model.User;

/**
 * @author aubrey
 * @date  下午3:57:51
 * 
 */

public class UserDaoTest {
	

	BeanFactory beanFactory = new ClassPathXmlApplicationContext("application.xml");
	UserDao userDao = beanFactory.getBean(UserDao.class);
	
	
	
	

	@Test
	public void testInsert() {
		
		
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}
	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		User user = new User();
		user.setName("admin");
		List<User> lists = userDao.query(user);
		System.out.println("==88888888888888888========================");
		lists = userDao.query(user);
		for(User u : lists) {
			System.out.println(u);
		}
	}

}
