package cn.tedu.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

public class NoteUtil {
	//����U��������UID�㷨
	public static String createId() {
		UUID uuid=UUID.randomUUID();
		return uuid.toString().replace("-", "");	
	}
	
	public static String md5(String src) {
		MessageDigest md;
		try {
			md=MessageDigest.getInstance("MD5");
			byte[] output=md.digest(src.getBytes());
			//��MD5����������Base64ת���ַ���
			//����
			String s=Base64.encodeBase64String(output);
			return s;
			
		}catch(Exception e) {
			throw new NoteException("�������ʧ��",e);
		}
	}
	public static void main(String[] args) throws Exception{
		//System.out.println(createId());
		System.out.println(md5("123456"));
	}
}
