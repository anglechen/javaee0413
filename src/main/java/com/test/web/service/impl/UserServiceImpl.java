/**
 *
 */
package com.test.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.web.dao.UserDao;
import com.test.web.model.User;
import com.test.web.service.UserService;

/**
 * @author aubrey
 * @date  下午1:53:01
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void del(User user) {
		userDao.del(user);
	}

	@Override
	public List<User> query(User user) {
		return userDao.query(user);
	}

}
