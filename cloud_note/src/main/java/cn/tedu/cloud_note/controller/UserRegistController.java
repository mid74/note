package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource(name="userService")
	private UserService service;
	@ResponseBody//µ˜”√jackson
	@RequestMapping("/add.do")//∆•≈‰«Î«Û
	public NoteResult<Object> add(String name,String password,String nick){
		NoteResult<Object> result=service.addUser(name, password, nick);
		return result;
	}
}
