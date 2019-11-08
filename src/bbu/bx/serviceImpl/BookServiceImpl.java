package bbu.bx.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbu.bx.dao.BookDao;
import bbu.bx.entity.Book;
import bbu.bx.service.BookService;
import bbu.bx.util.ManagerResult;
/**
 * Book服务层
 * @author 陶程凯
 *
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public ManagerResult<List<Book>> queryAll(String cid,String page) {
		ManagerResult<List<Book>> result = new ManagerResult<>();
		int count = bookDao.queryAllCount(cid);
		int num = (Integer.parseInt(page)-1)*8+1;
		List<Book> list = null;
		if((count+7)/8<Integer.parseInt(page)) {
			list = bookDao.queryAllBook(cid,(Integer.parseInt(page)-2)*8+1);
			result.setStatu(2);
		}else {
			list = bookDao.queryAllBook(cid,num);
			result.setStatu(0);
		}
		if(list!=null&&list.size()!=0) {
			result.setMsg("查询成功");
			result.setData(list);
		}else {
			result.setStatu(1);
			result.setMsg("未查询到该类书籍");
		}
		return result;
	}

	@Override
	public ManagerResult<List<Book>> querySearch(String bname,String page) {
		ManagerResult<List<Book>> result = new ManagerResult<>();
		List<Book> list = null;
		int num = (Integer.parseInt(page)-1)*8+1;
		if("".equals(bname)) {
			int count = bookDao.queryCount();
			if((count+7)/8<Integer.parseInt(page)) {
				list = bookDao.queryBook((Integer.parseInt(page)-2)*8+1);
				result.setStatu(2);
			}else {
				list = bookDao.queryBook(num);
				result.setStatu(0);
			}
		}else {
			bname = "%"+bname+"%";
			int count = bookDao.querySearchCount(bname);
			if((count+7)/8<Integer.parseInt(page)) {
				list = bookDao.queryBySearch(bname,(Integer.parseInt(page)-2)*8+1);
				result.setStatu(2);
			}else {
				list = bookDao.queryBySearch(bname,num);
				result.setStatu(0);
			}
		}
		if(list!=null&&list.size()!=0) {
			result.setMsg("查询成功");
			result.setData(list);
		}else {
			result.setStatu(1);
			result.setMsg("查询失败");
		}
		return result;
	}

	@Override
	public ManagerResult<Book> queryBookById(String bid) {
		ManagerResult<Book> result = new ManagerResult<>();
		Book book = bookDao.queryBookById(bid);
		if(book!=null) {
			result.setStatu(0);
			result.setMsg("查询成功");
			result.setData(book);
		}else {
			result.setStatu(1);
			result.setMsg("查询失败");
		}
		return result;
	}

}
