package bbu.bx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbu.bx.entity.User;
import bbu.bx.service.UserService;
/**
 * User的控制层
 * @author 陶程凯
 *
 */
import bbu.bx.util.ManagerResult;
@Controller
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@RequestMapping("/view/login.do")
	@ResponseBody
	public ManagerResult<User> loginController(String login,String pwd){
		return userService.loginService(login, pwd);
	}
	@RequestMapping("/view/insertUser.do")
	@ResponseBody
	public ManagerResult<User> insertUserController(String login,String pwd,String email){
		return userService.insertUserService(login, pwd, email);
	}
	@RequestMapping("/view/updateUser.do")
	@ResponseBody
	public ManagerResult<User> updateUserController(String pwd,String uid){
		return userService.updateUserService(pwd, uid);
	}
}
