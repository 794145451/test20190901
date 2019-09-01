package com.qintian;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @Title: HelloJob.java
 * @Package com.qintian
 * @Description: 任务
 * @author Chao_Xie
 * @date 2019年2月27日 下午8:35:47
 * @version 1.0
 */


public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
/*		//打印当前的执行的时间
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate  = f.format(date);
		System.out.println("当前时间:"+nowDate);
		
		//编写具体的业务流程
		System.out.println("Hello World!");*/
				
	}
	
	public void run(){
		System.out.println(new SimpleDateFormat("任务执行了"+"yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
