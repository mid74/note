package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.aspect.LoggerBean;


public class TestBookService {
	private BookService service;
	@Before
	public void init() {	
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		service=ctx.getBean("bookService",BookService.class);	
	
	}



}
