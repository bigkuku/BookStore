package bbu.bx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbu.bx.entity.Book;
import bbu.bx.service.BookService;
import bbu.bx.util.ManagerResult;

/**
 * Book控制层
 * @author 陶程凯
 *
 */
@Controller
public class BookController {
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;
	@RequestMapping("/view/all.do")
	@ResponseBody
	public ManagerResult<List<Book>> queryAllController(String cid,String page){
		return bookService.queryAll(cid,page);
	}
	@RequestMapping("/view/search.do")
	@ResponseBody
	public ManagerResult<List<Book>> querySearchController(String bname,String page){
		return bookService.querySearch(bname,page);
	}
	@RequestMapping("/view/searchid.do")
	@ResponseBody
	public ManagerResult<Book> queryBookByIdController(String bid){
		return bookService.queryBookById(bid);
	}
}
