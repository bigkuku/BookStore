package bbu.bx.service;

import bbu.bx.entity.User;
import bbu.bx.util.ManagerResult;
/**
 * User的服务接口
 * @author 陶程凯
 *
 */
public interface UserService {
	public ManagerResult<User> loginService(String login,String pwd);
	public ManagerResult<User> insertUserService(String login,String pwd,String meail);
	public ManagerResult<User> updateUserService(String pwd,String uid);
}
