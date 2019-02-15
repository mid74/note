package cn.tedu.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

public class NoteUtil {
	//利用U生成主键UID算法
	public static String createId() {
		UUID uuid=UUID.randomUUID();
		return uuid.toString().replace("-", "");	
	}
	
	public static String md5(String src) {
		MessageDigest md;
		try {
			md=MessageDigest.getInstance("MD5");
			byte[] output=md.digest(src.getBytes());
			//将MD5处理结果利用Base64转成字符串
			//加密
			String s=Base64.encodeBase64String(output);
			return s;
			
		}catch(Exception e) {
			throw new NoteException("密码加密失败",e);
		}
	}
	public static void main(String[] args) throws Exception{
		//System.out.println(createId());
		System.out.println(md5("123456"));
	}
}
