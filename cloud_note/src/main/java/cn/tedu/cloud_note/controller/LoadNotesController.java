package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/note")
public class LoadNotesController {
	@Resource
	private NoteService noteSerivce;
	@RequestMapping("/loadnotes.do")
	@ResponseBody
	public NoteResult<List<Map>> excute(String bookId){
		NoteResult<List<Map>> result=noteSerivce.loadBookNotes(bookId);
		return result;		
	}
}
