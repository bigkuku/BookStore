package bbu.bx.service;

import java.util.List;

import bbu.bx.entity.Order;
import bbu.bx.util.ManagerResult;
/**
 * order服务层接口
 * @author 陶程凯
 *
 */
public interface OrderService {
	public ManagerResult<List<Order>> queryOrder(String uid,int status);
	public ManagerResult<Order> saveOrder(String total,int status,String bname,String uid);
	public ManagerResult<Order> modifyOrder(String oid);
}
