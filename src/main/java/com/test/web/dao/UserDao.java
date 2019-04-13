/**
 *
 */
package com.test.web.dao;

import java.util.List;

import com.test.web.model.User;

/**
 * @author aubrey
 * @date  下午2:26:57
 * 
 */
public interface UserDao {
	
	public void insert(User user);
	
	public void update(User user);
	
	public void del(User user);
	
	public List<User> query(User user);
	
	
	
}
