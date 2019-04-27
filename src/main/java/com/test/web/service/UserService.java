/**
 *
 */
package com.test.web.service;

import java.util.List;

import com.test.web.model.User;

/**
 * @author aubrey
 * @date  下午1:52:22
 * 
 */
public interface UserService {
	public void insert(User user);
	
	public void update(User user);
	
	public void del(User user);
	
	public List<User> query(User user);
	
}
