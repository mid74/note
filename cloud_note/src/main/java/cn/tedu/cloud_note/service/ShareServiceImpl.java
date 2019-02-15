package cn.tedu.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.dao.ShareDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
@Service("shareService")
public class ShareServiceImpl implements ShareService {
	@Resource
	private ShareDao shareDao;
	@Resource
	private NoteDao noteDao;
	public NoteResult addShare(String noteId) {
		Share share=new Share();
		NoteResult<Share> result=new NoteResult<Share>();
		String id=NoteUtil.createId();
		share.setCn_share_id(id);
		Note note=noteDao.findByNoteId(noteId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_note_id(noteId);
		shareDao.AddShare(share);
		result.setStatus(0);
		result.setMsg("成功");
		//模拟异常
		//String str=null;
		//str.length();
		return result;
	}
	public NoteResult<List<Share>> findByTitle(String keyword,int page) {
		NoteResult<List<Share>> result=new NoteResult<List<Share>>();
		keyword="%"+keyword+"%";
		int begin=(page-1)*3;//计算抓取记录的起点		
		Map<String,Object> parames=new HashMap<String,Object>();
		parames.put("keyword",keyword);
		parames.put("begin",begin);
		List<Share> list=shareDao.findByTitle(parames);		
		result.setData(list);
		result.setStatus(0);
		result.setMsg("查询成功");
		return result;
	}

}
