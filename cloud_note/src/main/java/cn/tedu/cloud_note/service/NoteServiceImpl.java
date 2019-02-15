package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteDao noteDao;
	public NoteResult<List<Map>> loadBookNotes(String bookId) {
		List<Map> list=noteDao.findByBookId(bookId);
		NoteResult<List<Map>> result=new NoteResult<List<Map>>();
		result.setStatus(0);
		result.setMsg("成功");
		result.setData(list);
		return result;
	}
	public NoteResult<Note> loadNote(String noteId) {
		Note note=noteDao.findByNoteId(noteId);
		NoteResult<Note> result=new NoteResult<Note>();
		if(note==null) {
			result.setStatus(1);
			result.setMsg("未找到数据");
			return result;
		}else {
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(note);
			return result;
		}
	}
	public NoteResult updateNote(String noteId,String noteTitle,String noteBody) {
		Note note=new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		Long time=System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		//跟新数据库
		int i=noteDao.updateNote(note);
		System.out.print(i);
		NoteResult result=new NoteResult();
		if(i==1) {
			result.setMsg("成功");
			result.setStatus(0);
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("未更新");
			return result;
		}
	}
	public NoteResult<Note> addNote(String userId, String bookId, String title) {
		Note note=new Note();
		note.setCn_user_id(userId);
		note.setCn_note_title(title);
		note.setCn_notebook_id(bookId);
		String noteId=NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_note_body("");
		Long time=System.currentTimeMillis();
		//创建时间
		note.setCn_note_create_time(time);
		//最后修改时间
		note.setCn_note_last_modify_time(time);
		//状态：1.normal 2.delete
		note.setCn_note_status_id("1");
		//类型:1.normal 2.favor收藏    3.share
		noteDao.save(note);
		NoteResult<Note> result=new NoteResult<Note>();
		result.setStatus(0);
		result.setMsg("成功");
		result.setData(note);
		return result;
	}
	@Transactional
	public void deleteNotes(String... ids) {
		for(String id:ids) {
			int n=noteDao.deleteNote(id);
			if(n!=1) {
				//抛出异常触发，事务的回滚
				throw new RuntimeException("删错了");
			}
		}
	}
}
