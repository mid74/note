package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class TestBase {
	public ApplicationContext getContext() {
		String[] conf= {"config/spring-mvc.xml","config/spring-mybatis.xml"};
		ApplicationContext ctx=new ClassPathXmlApplicationContext(conf);
		return ctx;		
	}
}
