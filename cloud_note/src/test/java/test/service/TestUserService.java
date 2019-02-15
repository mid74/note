package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

public class TestUserService {
	UserService service;
	UserDao dao;
	@Before
	public void init() {	
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-*.xml");
		service=ctx.getBean("userService",UserService.class);
		dao=ctx.getBean("userDao",UserDao.class);
		
	}
	@Test //用户名不存在
	public void test1() {
		NoteResult<User> result=service.ckeckLogin("sda", "ss");
		System.out.println(service.getClass().getName());
		System.out.println(result);
	}
	
	@Test
	public void test2() {
		NoteResult<User> result=service.ckeckLogin("demo", "11234567");
		System.out.println(result);
	}
	
	@Test
	public void test3() {
		NoteResult<User> result=service.ckeckLogin("demo", "1234567");
		System.out.println(result);
	}
	//注册测试
	@Test
	public void test4() {
		String name="zhou";
		String password="123456";
		String nick="xiaodi";
		NoteResult<Object> result =service.addUser(name, password, nick);
		System.out.println(result);
	}
	@Test
	public void test5() {
		String userId="48595f52-b22c-4485-9244-f4004255b972";
		String final_password="123456";
		String name="demo";
		User user=new User();
		user.setCn_user_password(final_password);
		user.setCn_user_id(userId);
		user.setCn_user_name(name);
		System.out.println(user.getCn_user_id());
		dao.updateUser(user);
		
		System.out.println(dao.findById(userId));
	}
}
