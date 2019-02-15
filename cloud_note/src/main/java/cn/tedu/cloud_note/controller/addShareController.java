package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;
import cn.tedu.cloud_note.entity.Share;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.ShareService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class addShareController {
	@Resource
	private ShareService serive;
	@RequestMapping("add.do")
	@ResponseBody
	public NoteResult<Share> addShare(String noteId){
		NoteResult<Share> result=serive.addShare(noteId);
		return result;
	}
}
