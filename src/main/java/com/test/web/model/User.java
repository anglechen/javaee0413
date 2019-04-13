/**
 * 
 */
package com.test.web.model;



import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Administrator
 * 用户类
 * 抽取公共类： extends BaseEntity
 */
public class User{ /**
     * id
     */
	private Integer id;
	
	/**
	 * 名字
	 */
	private String name;
	
	private String password;
	
	private String phone;
	
	private Integer sex;
	
	private Integer age;
	
	private String addr;
	
	private String remarks;
	
	private Integer status;

}
