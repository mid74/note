	package cn.tedu.cloud_note.dao;

import cn.tedu.cloud_note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public void save(User user);
	public void updateUser(User user);
	public User findById(String userId);
}
