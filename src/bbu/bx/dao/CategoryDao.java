package bbu.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import bbu.bx.entity.Category;

/**
 * CategoryDao层
 * @author 陶程凯
 *
 */
public interface CategoryDao {
	@Select("select * from category where pid is null")
	public List<Category> queryFirstCategory();
	@Select("select * from category where pid = #{cid}")
	public List<Category> querySecondCategory(String cid);
}
