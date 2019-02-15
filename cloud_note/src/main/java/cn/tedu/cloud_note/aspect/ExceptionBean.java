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
	//e目标组件抛出来的对象
	@AfterThrowing(throwing="e",pointcut="within(cn.tedu.cloud_note.service..*)")
	public void execute(Exception e) {
		try {
			//加true以追加的方式写
			FileWriter fw=new FileWriter("F:\\note_error.txt",true);
			PrintWriter pw=new PrintWriter(fw);
			//利用pw对象写入异常信息
			Date time =new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr=sdf.format(time);
			pw.println("**************");
			pw.println("异常类型"+ e);
			pw.println("异常事件"+timeStr);
			pw.println("****异常详细信息****");
			e.printStackTrace(pw);
			pw.close();
			fw.close();
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("异常记录失败");
		}
	}
}
