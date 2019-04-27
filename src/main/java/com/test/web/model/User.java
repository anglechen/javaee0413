/**
 * 
 */
package com.test.web.model;



import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description="user实体",value="user")
public class User implements Serializable{ 
	/**
     * id
     */
	@ApiModelProperty(value="ID",required=true)
	private Integer id;
	/**
	 * 名字
	 */
	@NotNull(message="不能为空")
	@ApiModelProperty(value="姓名")
	private String name;
	
	@NotNull
	private String password;
	
	private String phone;
	
	private Integer sex;
	
	@Range(min=1,max=100)
	private Integer age;
	
	private String addr;
	
	private String remarks;
	
	private Integer status;
	
	
	public void test() {
		log.info("test。。。。。");
	}
}
