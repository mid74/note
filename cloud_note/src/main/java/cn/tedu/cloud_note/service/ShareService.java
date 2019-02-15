package cn.tedu.cloud_note.service;
import java.util.List;

import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.util.NoteResult;
public interface ShareService {
	public NoteResult addShare(String noteId);
	public NoteResult<List<Share>> findByTitle(String keyword,int page);
}
