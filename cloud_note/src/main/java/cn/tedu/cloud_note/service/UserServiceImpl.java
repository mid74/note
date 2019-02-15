package cn.tedu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	public NoteResult<User> ckeckLogin(String name, String password) {
		NoteResult<User> result=new NoteResult<User>();
		User user=userDao.findByName(name);
		//检测用户名和密码
		if(user==null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		String md5Password=NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码不对");
			return result;
		}
		//都正确时
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}
	
	
	public NoteResult<Object> addUser(String name, String password,String nick) {
		User hasUser=userDao.findByName(name);
		NoteResult<Object> result=new NoteResult<Object>();
		if(hasUser!=null) {
			result.setStatus(1);
			result.setMsg("账号重复");
			return result;
		}
		//添加新用户
		User user=new User();
		user.setCn_user_name(name);
		String id=NoteUtil.createId();
		user.setCn_user_id(id);
		String md5Password=NoteUtil.md5(password);
		user.setCn_user_password(md5Password);
		user.setCn_user_nick(nick);
		//插入用户数据
		userDao.save(user);
		//构建返回结果
		result.setStatus(0);
		result.setMsg("注册成功");
		return result;
	}


	public NoteResult<Object> updateUser(String userId, String last_password, String final_password) {
		NoteResult<Object> result =new NoteResult<Object>();
		User findUser=userDao.findById(userId);
		String Md5=NoteUtil.md5(last_password);
		User user=new User();
		if(!(findUser.getCn_user_password().equals(Md5))){
			System.out.println(findUser.getCn_user_password());
			System.out.println(NoteUtil.md5(last_password));
			result.setStatus(1);
			result.setMsg("原密码输入错误");
			return result;
		}
		System.out.println(final_password);
		user.setCn_user_password(NoteUtil.md5(final_password));
		user.setCn_user_name(findUser.getCn_user_name());
		userDao.updateUser(user);
		result.setStatus(0);
		result.setMsg("修改成功");
		return result;
	}

}
