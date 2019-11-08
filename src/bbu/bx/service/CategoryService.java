package bbu.bx.service;

import java.util.List;

import bbu.bx.entity.Category;
import bbu.bx.util.ManagerResult;
/**
 * Category服务层接口
 * @author 陶程凯
 *
 */
public interface CategoryService {
	public ManagerResult<List<Category>> queryCategoryFirst();
	public ManagerResult<List<Category>> queryCategorySecond(String cid);
}
