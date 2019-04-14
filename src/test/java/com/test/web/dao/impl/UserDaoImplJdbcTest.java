/**
 *
 */
package com.test.web.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.test.web.dao.UserDao;
import com.test.web.model.User;

/**
 * @author aubrey
 * @date  下午1:55:32
 * 
 */
public class UserDaoImplJdbcTest {

	/**
	 * Test method for {@link com.test.web.dao.impl.UserDaoImplJdbc#insert(com.test.web.model.User)}.
	 */
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.test.web.dao.impl.UserDaoImplJdbc#update(com.test.web.model.User)}.
	 */
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.test.web.dao.impl.UserDaoImplJdbc#del(com.test.web.model.User)}.
	 */
	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.test.web.dao.impl.UserDaoImplJdbc#query(com.test.web.model.User)}.
	 */
	@Test
	public void testQuery() {
		UserDao userDao = new UserDaoImplJdbc();
		List<User> lists = userDao.query(new User());
		for(User u : lists) {
			System.out.println(u);
		}
	}
	
	
	
	
	
	

}
