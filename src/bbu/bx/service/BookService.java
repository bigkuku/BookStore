package bbu.bx.service;

import java.util.List;

import bbu.bx.entity.Book;
import bbu.bx.util.ManagerResult;
/**
 * Book服务层接口
 * @author 陶程凯
 *
 */
public interface BookService {
	public ManagerResult<List<Book>> queryAll(String cid,String page);
	public ManagerResult<List<Book>> querySearch(String bname,String page);
	public ManagerResult<Book> queryBookById(String bid);
}
