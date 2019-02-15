package cn.tedu.cloud_note.dao;

import java.util.List;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.entity.User;

public interface BookDao {
	public List<Book> findByUserId(String userId);
	
}
