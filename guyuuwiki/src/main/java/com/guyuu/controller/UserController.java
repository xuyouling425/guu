package com.guyuu.controller;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guyuu.core.service.BaseService;
import com.guyuu.model.User;
import com.guyuu.system.model.WikiUser;
import com.guyuu.system.service.UserServiceImpl;

@Controller
@RequestMapping("/hello")
public class UserController {
	
	@Resource(name="userServiceImpl")
	private UserServiceImpl userService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public User helloUser(@RequestParam(value="name",required=false,defaultValue="world !") String name)
	{
		final String template = "hello $S!";	
		WikiUser user = null;
		 try {
			 user = (WikiUser) userService.selectBypk("guu.20140409");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new User(1, user.getRegisterName());
	}

	@RequestMapping("/h1")
	public User hello(@RequestParam(value="name",required=false,defaultValue="world !") String name)
	{
		final String template = "hello $S!";	
		return new User(1, String.format(template, name));
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
		
	}
}
