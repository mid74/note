package test.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.dao.ShareDao;
import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.service.ShareService;
import cn.tedu.cloud_note.service.ShareServiceImpl;

public class TestShareDao {
	@Test
	public void Testshare() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		ShareDao dao=ctx.getBean("shareDao",ShareDao.class);
		String shareId="mybatis";
		String shareT="share";
		String body="¹þ¹þ";
		String id="0e086e15000e4d3385afef193c18bb89";
		Share share=new Share();
		share.setCn_note_id(id);
		share.setCn_share_title(shareT);
		share.setCn_share_body(body);
		share.setCn_share_id(shareId);
		dao.AddShare(share);
	}
	
	@Test
	public void TestshareService() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		ShareService dao=ctx.getBean("shareService",ShareServiceImpl.class);
		//System.out.print(dao.findByTitle("²âÊÔ"));
	}
	
	@Test
	public void TestfindService() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		ShareDao dao=ctx.getBean("shareDao",ShareDao.class);
		//List<Share> list=dao.findByTitle("²âÊÔ");
		//System.out.println(list);
	}
}
