package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.Note;



public interface NoteDao {
	public List<Map> findByBookId(String bookId);
	public Note findByNoteId(String noteId);
	public int updateNote(Note note);
	public int updateNoteByMap(Map<String,Object> map);
	public void save(Note note);
	/*
	 * map 中需要添加参数:
	 * map={ids:[id1,id2,id3..],status:2}
	 */
	public int deleteNotes(Map<String,Object> map);
	public int deleteNote(String id);
}
