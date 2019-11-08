package bbu.bx.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbu.bx.dao.OrderDao;
import bbu.bx.entity.Order;
import bbu.bx.service.OrderService;
import bbu.bx.util.CreateId;
import bbu.bx.util.ManagerResult;
/**
 * order服务层
 * @author 陶程凯
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Override
	public ManagerResult<List<Order>> queryOrder(String uid, int status) {
		ManagerResult<List<Order>> result = new ManagerResult<>();
		List<Order> list = orderDao.queryOrder(uid, status);
		if(list!=null&&list.size()!=0) {
			result.setStatu(0);
			result.setMsg("查询成功");
			result.setData(list);
		}else {
			result.setStatu(1);
			result.setMsg("查询失败");
		}
		return result;
	}

	@Override
	public ManagerResult<Order> saveOrder(String total, int status, String bname, String uid) {
		ManagerResult<Order> result = new ManagerResult<>();
		Order order = new Order();
		order.setOid(CreateId.getId());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOrdertime(df.format(new Date()));
        order.setStatus(status);
        order.setBname(bname);
        order.setTotal(total);
        order.setUid(uid);
        int n = orderDao.saveOrder(order);
        if(n==1) {
        	result.setStatu(0);
			if(status==0) {
				result.setMsg("成功加入购物车");
			}else {
				result.setMsg("购买成功");
			}
			result.setData(order);
        }else {
        	result.setStatu(1);
			if(status==0) {
				result.setMsg("加入购物车失败");
			}else {
				result.setMsg("购买失败");
			}
        }
		return result;
	}

	@Override
	public ManagerResult<Order> modifyOrder(String oid) {
		ManagerResult<Order> result = new ManagerResult<>();
		int n = orderDao.modify(oid);
		if(n==1) {
			result.setStatu(0);
			result.setMsg("购买成功");
		}else {
			result.setStatu(1);
			result.setMsg("购买失败");
		}
		return result;
	}

}
