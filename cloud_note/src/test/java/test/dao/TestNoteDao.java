package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;

public class TestNoteDao {
	@Test
	public void TestNote() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		NoteDao dao=ctx.getBean("noteDao",NoteDao.class);
		List<Map> list=dao.findByBookId("623c1074d04641f78a04afc4ed64e684");
		for(Map note:list) {
			System.out.println(note.get("cn_note_title"));
		}

	}
	@Test
	public void TestFind() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		NoteDao dao=ctx.getBean("noteDao",NoteDao.class);
		Note note=dao.findByNoteId("0e086e15000e4d3385afef193c18bb89");
		System.out.println(note.getCn_note_title()+","+note.getCn_note_body());
	}
	
	@Test
	public void Testupdate() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		NoteDao dao=ctx.getBean("noteDao",NoteDao.class);
		Note note=new Note();
		note.setCn_note_title("我是阿生");
		note.setCn_note_id("0e086e15000e4d3385afef193c18bb89");
		note.setCn_note_body("jaa");
		Long time=System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		int i=dao.updateNote(note);
		System.out.println(i);
	}
	
	@Test
	public void Testupdate2() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		NoteDao dao=ctx.getBean("noteDao",NoteDao.class);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("title","javaee");
		map.put("noteId", "0e086e15000e4d3385afef193c18bb89");
		//故意省去body和time
		dao.updateNoteByMap(map);
	}
	@Test
	public void Testdelect() {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
		NoteDao dao=ctx.getBean("noteDao",NoteDao.class);
		Map<String,Object> map=new HashMap<String,Object>();
		String[] ids= {"id1","id2","id3"};
		map.put("ids", ids);
		map.put("status", 2);
		int n=dao.deleteNotes(map);	
		System.out.println(n);
		}
}
