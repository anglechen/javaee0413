/**
 *
 */
package com.test.web.dao.impl;

import java.util.List;

import com.test.web.dao.UserDao;
import com.test.web.model.User;

import lombok.Data;

/**
 * @author aubrey
 * @date  下午4:47:44
 * 
 */
@Data
public class UserDaoImpl2 implements UserDao {
	
	private String test;
	
	public UserDaoImpl2() {
	}
	
	public UserDaoImpl2(String t) {
		this.test = t;
	}

	@Override
	public void insert(User user) {
		System.out.println("insert方法");
	}

	@Override
	public void update(User user) {
		System.out.println("update方法");
		
	}

	@Override
	public void del(User user) {
		System.out.println("del方法");
		
	}

	@Override
	public List<User> query(User user) {
		System.out.println("query方法");
		return null;
	}

	
	
}
