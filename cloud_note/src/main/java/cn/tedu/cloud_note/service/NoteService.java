package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;

public interface NoteService {
	public NoteResult<List<Map>> loadBookNotes(String bookId);
	public NoteResult<Note> loadNote(String noteId);
	public NoteResult updateNote(String noteId,String noteTitle,String noteBody);
	public NoteResult<Note> addNote(String userId,String bookId,String title);
	//String... ��̬����������String[]����
	public void deleteNotes(String...ids);
}
