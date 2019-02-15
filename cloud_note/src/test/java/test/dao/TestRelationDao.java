package test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.RelationDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.entity.User;

public class TestRelationDao {
	private RelationDao rdao;
	@Test
	public void TestMany() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		rdao=ctx.getBean("relationDao",RelationDao.class);
		User user=rdao.findUserAndBooks("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println("====信息===");
		System.out.println("名字"+user.getCn_user_name());
		System.out.println("昵称"+user.getCn_user_nick());
		System.out.println("笔记本熟练"+user.getBooks().size());
		for(Book book:user.getBooks()) {
			System.out.println("1w"+book.getCn_notebook_name());
			System.out.println("2w"+book.getCn_notebook_id());
		}
	}
	@Test 
	public void testOne() {
		System.out.println("ss");
		List<Book> books = rdao.findBookAndUser();
		for(Book book:books) {
			System.out.println(book.getCn_notebook_name());
			if(book.getUser()!=null) {
				System.out.println(book.getUser().getCn_user_name());
			}
		}
	}
}