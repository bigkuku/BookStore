package bbu.bx.entity;

import java.io.Serializable;
/**
 * User类
 * @author 陶程凯
 *
 */
public class User implements Serializable {
	private String uid;
	private String login;
	private String pwd;
	private String email;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
