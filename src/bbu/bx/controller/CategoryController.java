package bbu.bx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbu.bx.entity.Category;
import bbu.bx.service.CategoryService;
import bbu.bx.util.ManagerResult;

/**
 * Category控制层
 * @author 陶程凯
 *
 */
@Controller
public class CategoryController {
	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	@RequestMapping("/view/queryFirst.do")
	@ResponseBody
	public ManagerResult<List<Category>> queryCategoryFisrtController(){
		return categoryService.queryCategoryFirst();
	}
	@RequestMapping("/view/querySecond.do")
	@ResponseBody
	public ManagerResult<List<Category>> queryCategorySecondController(String cid){
		return categoryService.queryCategorySecond(cid);
	}
}
