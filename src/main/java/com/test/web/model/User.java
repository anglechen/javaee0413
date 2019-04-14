/**
 * 
 */
package com.test.web.model;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * 用户类
 * 抽取公共类： extends BaseEntity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class User implements Serializable{ 
	/**
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
	
	
	public void test() {
		log.info("test。。。。。");
	}
}
