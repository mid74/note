package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;
@Controller
@RequestMapping("/user")//匹配请求路径
public class UserLoginController {
	@Resource(name="userService")
	private UserService service;
	@ResponseBody//调用jackson
	@RequestMapping("/login.do")//匹配请求
	public NoteResult<User> execute(String name,String password){
		
		NoteResult<User> result=service.ckeckLogin(name, password);
		System.out.println(name);
		return result;
	}
	
}
