package bbu.bx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import bbu.bx.entity.User;
/**
 * User的Dao层
 * @author 陶程凯
 *
 */
public interface UserDao {
	@Select("select * from user where login = #{login} and pwd = #{pwd}")
	public User login(@Param("login")String login,@Param("pwd")String pwd);
	@Insert("insert into user(uid,login,pwd,email) value(#{uid},#{login},#{pwd},#{email})")
	public int insertUser(User user);
	@Update("update user set pwd = #{pwd} where uid = #{uid}")
	public int updatePwd(@Param("pwd")String pwd,@Param("uid")String uid);
}
