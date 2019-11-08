package bbu.bx.util;

import java.io.Serializable;
/**
 * 对结果集的封装
 * @author 陶程凯
 *
 * @param <T>
 */
public class ManagerResult<T> implements Serializable {
	private int statu;
	private String msg;
	private T data;
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
