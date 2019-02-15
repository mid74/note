package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;
@Controller
@RequestMapping("/user")
public class updateUser {
		@Resource
		private UserService userService;
		@ResponseBody
		@RequestMapping("/change.do")
		public NoteResult<Object> UpdateUser(String userId,String last_password,String final_password){
			NoteResult<Object> result=userService.updateUser(userId, last_password, final_password);
			return result;
					
		}
}
