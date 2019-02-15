package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;

public interface UserService {
	public NoteResult<User> ckeckLogin(String name,String password);
	public NoteResult<Object> addUser(String name,String password,String nike);
	public NoteResult<Object> updateUser(String userName,String last_password,String final_password);
}
