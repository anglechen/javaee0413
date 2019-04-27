/**
 *
 */
package com.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author aubrey
 * @date  上午10:01:08
 * 
 */
@Controller
@Api(value="测试信息")
public class TestController {
	
	@RequestMapping("/hello")
	@ResponseBody
	@Valid
	@ApiOperation(value="测试查询",notes="测试备注")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "result", value = "校验结果", required = false)
    })
	public String test( User user,BindingResult result) {
//	public String test( User user) {
		int i = 1/0;
		while(result.hasErrors()) {
			for(ObjectError e : result.getAllErrors()) {
				System.out.println(e.getObjectName() + ":" + e.getDefaultMessage());
			}
			return "error";
		}
		return "hello ";
	}
}
