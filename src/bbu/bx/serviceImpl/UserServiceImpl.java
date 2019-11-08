package bbu.bx.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbu.bx.dao.UserDao;
import bbu.bx.entity.User;
import bbu.bx.service.UserService;
import bbu.bx.util.CreateId;
import bbu.bx.util.ManagerResult;
/**
 * User的服务层
 * @author 陶程凯
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public ManagerResult<User> loginService(String login, String pwd) {
		ManagerResult<User> result = new ManagerResult<User>();
		User user = userDao.login(login, pwd);
		if(user!=null) {
			result.setStatu(0);
			result.setMsg("查询成功");
			result.setData(user);
		}else {
			result.setStatu(1);
			result.setMsg("用户名或密码错误");
		}
		return result;
	}
	@Override
	public ManagerResult<User> insertUserService(String login, String pwd, String email) {
		ManagerResult<User> result = new ManagerResult<>();
		User user = new User();
		user.setUid(CreateId.getId());
		user.setLogin(login);
		user.setPwd(pwd);
		user.setEmail(email);
		int n = userDao.insertUser(user);
		if(n==1) {
			result.setStatu(0);
			result.setMsg("注册成功");
			result.setData(user);
		}else {
			result.setStatu(1);
			result.setMsg("注册失败");
		}
		return result;
	}
	@Override
	public ManagerResult<User> updateUserService(String pwd, String uid) {
		ManagerResult<User> result = new ManagerResult<>();
		int n = userDao.updatePwd(pwd, uid);
		if(n==1) {
			result.setStatu(0);
			result.setMsg("修改密码成功");
		}else {
			result.setStatu(1);
			result.setMsg("修改密码失败");
		}
		return result;
	}

}
