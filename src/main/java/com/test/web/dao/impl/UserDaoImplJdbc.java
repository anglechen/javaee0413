/**
 *
 */
package com.test.web.dao.impl;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

import org.apache.commons.beanutils.BeanUtils;

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

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void del(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> query(User user) {
		List<Map> results = new ArrayList<>();
		
		List<User> userLists = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//加载配置文件
			InputStream in = UserDaoImplJdbc.class.getResourceAsStream("/jdbc.properties");
			Properties props = new Properties();
			props.load(in);
			//获取连接
			Connection conn = DriverManager.getConnection(props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
			//创建statement
			Statement stat = conn.createStatement();
			String sql = "select * from user";
			ResultSet resultSet = stat.executeQuery(sql);
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			int count = metaData.getColumnCount();
			
			//遍历结果集
			while(resultSet.next()) {
				Map map = new HashMap();
				
				User tempUser = new User();
				
				for(int i = 1; i <= count ; i++) {
					//数据库列的标签名称
					Field field = User.class.getDeclaredField(metaData.getColumnLabel(i));
					
					
					String fname = field.getName();//属性的名称
					String sname = field.getType().getSimpleName();//获取属性类型
					//例如：setId,setName
					String setName = "set" + fname.substring(0, 1).toUpperCase() + fname.substring(1);
					//按照方法名称取方法
					Method method = User.class.getMethod(setName, field.getType());
					//根据类型执行方法
					if("Integer".equals(sname)) {
						Integer value = null;
						if(resultSet.getString(i) !=null) value = Integer.parseInt(resultSet.getString(i));
						method.invoke(tempUser, value);
						//tempUser.setId(value)
					}else {
						method.invoke(tempUser, resultSet.getString(i));
					}
					
					
					System.out.println(metaData.getColumnLabel(i));
					map.put(metaData.getColumnLabel(i), resultSet.getString(i));
					
					
				}
//				BeanUtils.copyProperties(dest, orig);
//				BeanUtils.populate(tempUser, map);//通过工具类直接转换为bean
				userLists.add(tempUser);
				results.add(map);
			}
			
//			System.out.println("list" + userLists);
			
			
			
			resultSet.close();
			stat.close();
			conn.close();
//			System.out.println(results);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return userLists;
	}
	
	
	
	

}
