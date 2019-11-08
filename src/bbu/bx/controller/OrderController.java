package bbu.bx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbu.bx.entity.Order;
import bbu.bx.service.OrderService;
import bbu.bx.util.ManagerResult;
/**
 * order控制层
 * @author 陶程凯
 *
 */
@Controller
public class OrderController {
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	@RequestMapping("/view/queryOrder.do")
	@ResponseBody
	public ManagerResult<List<Order>> queryOrderController(String uid,int status){
		return orderService.queryOrder(uid, status);
	}
	@RequestMapping("/view/saveOrder.do")
	@ResponseBody
	public ManagerResult<Order> saveOrderController(String total,int status,String bname,String uid){
		return orderService.saveOrder(total, status, bname, uid);
	}
	@RequestMapping("/view/modifyOrder.do")
	@ResponseBody
	public ManagerResult<Order> modifyOrderController(String oid){
		return orderService.modifyOrder(oid);
	}
}
