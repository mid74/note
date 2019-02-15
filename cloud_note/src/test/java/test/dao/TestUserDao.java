package test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;

public class TestUserDao {
	@Test
	public void testUserDao() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		UserDao dao=ctx.getBean("userDao",UserDao.class);
		User user=dao.findByName("demo");
		
		System.out.print(dao.findByName("张三"));
	}
	
	@Test
	public void testSave() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		UserDao dao=ctx.getBean("userDao",UserDao.class);
		User user =new User();
		user.setCn_user_id("123456");
		user.setCn_user_name("张三");
		user.setCn_user_password("123456");
		user.setCn_user_nick("筱狄");
		dao.save(user);
		
	}
}
