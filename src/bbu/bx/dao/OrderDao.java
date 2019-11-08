package bbu.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import bbu.bx.entity.Order;

/**
 * orderDAO层
 * @author 陶程凯
 *
 */
public interface OrderDao {
	@Select("select * from order1 where uid= #{uid} and status = #{status}")
	public List<Order> queryOrder(@Param("uid")String uid,@Param("status")int status);
	@Insert("insert into order1(oid,ordertime,total,status,bname,uid) values(#{oid},#{ordertime},#{total},#{status},#{bname},#{uid})")
	public int saveOrder(Order order);
	@Update("update order1 set status=1 where oid=#{oid}")
	public int modify(String oid);
}
