package bbu.bx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import bbu.bx.entity.Book;

/**
 * BookDao层
 * @author 陶程凯
 *
 */
public interface BookDao {
	@Select("select * from book where cid = #{cid} limit #{page},8")
	public List<Book> queryAllBook(@Param("cid")String cid,@Param("page")int page);
	@Select("select * from book where bname like #{bname} limit #{page},8")
	public List<Book> queryBySearch(@Param("bname")String bname,@Param("page")int page);
	@Select("select count(*) from book where cid = #{cid}")
	public int queryAllCount(String cid);
	@Select("select count(*) from book where bname like #{bname}")
	public int querySearchCount(String bname);
	@Select("select count(*) from book")
	public int queryCount();
	@Select("select * from book where bid = #{bid}")
	public Book queryBookById(String bid);
	@Select("select * from book limit #{page},8")
	public List<Book> queryBook(int page);
}
