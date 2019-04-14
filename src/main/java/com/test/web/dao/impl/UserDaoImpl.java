/**
 *
 */
package com.test.web.dao.impl;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.web.aop.LogAnnotation;
import com.test.web.dao.UserDao;
import com.test.web.model.User;

/**
 * @author aubrey
 * @date  下午2:33:02
 * 
 */
//@Repository
//@Controller
//@Service
//@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	
	
	@Override
	@LogAnnotation(name="admin")
	public void insert(User user) {
		/*String sql = "insert into user(name,password)"
				+ " values('"+ user.getName()+"','"+user.getPassword()+"')";
		*/
		String sql = "insert into user(name,password) values(?,?)";
		jdbcTemplate.update(sql, user.getName(),user.getPassword());
		System.out.println("执行sql " + sql);
	}


	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.test.web.dao.UserDao#update(com.test.web.model.User)
	 */
	@LogAnnotation(name="admin")
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.test.web.dao.UserDao#del(com.test.web.model.User)
	 */
	@Override
	public void del(User user) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.test.web.dao.UserDao#query(com.test.web.model.User)
	 */
	@Override
	public List<User> query(User user) {
		String sql = "select * from user";
		
		
		
		/*resultset 转换为 bean*/
		List<User> results = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
		return results;
	}
	
	
	
	
	
	
	

}
