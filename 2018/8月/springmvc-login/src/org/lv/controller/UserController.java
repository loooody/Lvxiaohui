package org.lv.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lv.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="user")
public class UserController {
	//静态List<User>集合，此处代替数据库用来保存注册的用户信息
	private static List<User> userList;
	//UserController类的构造器，初始化List<User>集合
	public UserController() {
		super();
		userList = new ArrayList<User>();
	}
	//静态的日志类LogFactory
	private static final Log logger = LogFactory.getLog(UserController.class);
	//该方法支持GET请求
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerForm() {
		logger.info("register GET方法被调用");
		//转跳到注册页面
		return "registerForm";
	}
	
	//该方法支持POST请求
	@RequestMapping(value="register",method=RequestMethod.POST)
	//将请求中的loginname参数的值赋给loginname变量，password，username同样处理
	public String register(
			@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			@RequestParam("username") String username) {
		logger.info("register POST方法被调用");
		//创建User对象
		User user = new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		user.setUsername(username);
		//模拟数据库存储User信息
		userList.add(user);
		//转跳到登录页面
		return "loginForm";
	}
	
	@RequestMapping("/login")
	public String login(
			@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			Model model) {
		logger.info("登录名："+loginname+" 密码:"+password);
		//到集合中查找用户是否存在，此处用来模拟数据库验证
		for(User user : userList) {
			if(user.getLoginname().equals(loginname) &&
					user.getPassword().equals(password)) {
				model.addAttribute("user",user);
				return "welcome";
			}
		}
		return "loginForm";
	}
	
}
