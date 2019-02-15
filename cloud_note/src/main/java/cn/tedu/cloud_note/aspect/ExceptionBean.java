package cn.tedu.cloud_note.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionBean {
	//eĿ������׳����Ķ���
	@AfterThrowing(throwing="e",pointcut="within(cn.tedu.cloud_note.service..*)")
	public void execute(Exception e) {
		try {
			//��true��׷�ӵķ�ʽд
			FileWriter fw=new FileWriter("F:\\note_error.txt",true);
			PrintWriter pw=new PrintWriter(fw);
			//����pw����д���쳣��Ϣ
			Date time =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr=sdf.format(time);
			pw.println("**************");
			pw.println("�쳣����"+ e);
			pw.println("�쳣�¼�"+timeStr);
			pw.println("****�쳣��ϸ��Ϣ****");
			e.printStackTrace(pw);
			pw.close();
			fw.close();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("�쳣��¼ʧ��");
		}
	}
}
