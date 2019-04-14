/**
 *
 */
package com.test.web.dao.impl;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.test.web.dao.UserDao;
import com.test.web.model.User;

/**
 * @author aubrey
 * @date  下午1:37:12
 * 
 */
public class UserDaoImplJdbc implements UserDao {

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.test.web.dao.UserDao#update(com.test.web.model.User)
	 */
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			InputStream in = UserDaoImplJdbc.class.getResourceAsStream("/jdbc.properties");
			Properties props = new Properties();
			props.load(in);
			Connection conn = DriverManager.getConnection(props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
			Statement stat = conn.createStatement();
			String sql = "select * from user";
			ResultSet resultSet = stat.executeQuery(sql);
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			int count = metaData.getColumnCount();
			List<Map> results = new ArrayList<>();
			while(resultSet.next()) {
				Map map = new HashMap();
				for(int i = 1; i <= count ; i++) {
					System.out.println(metaData.getColumnLabel(i));
					map.put(metaData.getColumnLabel(i), resultSet.getString(i));
				}
				results.add(map);
			}
			
			resultSet.close();
			stat.close();
			conn.close();
			System.out.println(results);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	
	
	
	

}
