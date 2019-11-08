package bbu.bx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbu.bx.dao.CategoryDao;
import bbu.bx.entity.Category;
import bbu.bx.service.CategoryService;
import bbu.bx.util.ManagerResult;
/**
 * Category服务层
 * @author 陶程凯
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public ManagerResult<List<Category>> queryCategoryFirst() {
		ManagerResult<List<Category>> result = new ManagerResult<>();
		List<Category> list = categoryDao.queryFirstCategory();
		if(list==null||list.size()==0) {
			result.setStatu(1);
			result.setMsg("没有书籍分类");
		}else {
			result.setStatu(0);
			result.setMsg("查询书籍分类成功");
			result.setData(list);
		}
		return result;
	}

	@Override
	public ManagerResult<List<Category>> queryCategorySecond(String cid) {
		ManagerResult<List<Category>> result = new ManagerResult<>();
		List<Category> list = categoryDao.querySecondCategory(cid);
		if(list==null||list.size()==0) {
			result.setStatu(1);
			result.setMsg("该分类没有子类");
		}else {
			result.setStatu(0);
			result.setMsg("子类查询成功");
			result.setData(list);
		}
		return result;
	}

}
