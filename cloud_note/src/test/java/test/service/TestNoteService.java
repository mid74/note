package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.service.NoteServiceImpl;
import cn.tedu.cloud_note.util.NoteResult;

public class TestNoteService {
	
		private static final String String = null;
		@Test
		public void TestBookS() {
			ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
			NoteService service=ctx.getBean("noteService",NoteServiceImpl.class);
			NoteResult<List<Map>> result=service.loadBookNotes("623c1074d04641f78a04afc4ed64e684");
			System.out.println(result.getMsg()+","+result.getData());
		}
		
		@Test
		public void TestShow() {
			ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
			NoteService service=ctx.getBean("noteService",NoteServiceImpl.class);
			NoteResult<Note> note=service.loadNote("0e086e15000e4d3385afef193c18bb89");
			System.out.println(note.getMsg());
			
		}
		@Test  
		public void TestUpdate() {
			ApplicationContext ctx =new ClassPathXmlApplicationContext("config/spring-mvc.xml");
			NoteService service=ctx.getBean("noteService",NoteService.class);
			String title="jav11a";
			String body="JDBC¿ª·¢";
			String id="0e086e15000e4d3385afef193c18bb89";
			NoteResult result=service.updateNote(id, title,body);
			System.out.println(result);
			NoteDao noteDao=ctx.getBean("noteDao",NoteDao.class);
		}
}
	
