/**
 *
 */
package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.model.User;
import com.test.web.service.UserService;

/**
 * @author aubrey
 * @date  下午1:46:21
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	
	/*@Autowired
	private HttpServletRequest req;
	
	
	@Autowired
	private HttpServletResponse resp;
	*/
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/in")
//	@ResponseBody
	public String login(@Valid User user,BindingResult result) {
		
		if(result.hasErrors()) {
			for( ObjectError e : result.getAllErrors()) {
				System.out.println(e.getObjectName() + ":" + e.getDefaultMessage());
			}
		}
		
		
		if("admin".equals(user.getName()) && "admin".equals(user.getPassword())  );
		List<User> Userresult = userService.query(user);
		if(Userresult.size() > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	
	
	
	
	
}
