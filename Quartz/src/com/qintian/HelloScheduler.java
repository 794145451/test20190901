package com.qintian;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @Title: HelloScheduler.java
 * @Package com.qintian
 * @Description: 调度器
 * @author Chao_Xie
 * @date 2019年2月27日 下午8:36:46
 * @version 1.0
 */
public class HelloScheduler {

	public static void main(String[] args) {

		//创建JobDetail任务，与HelloJob任务类绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1").build();
		
		//创建Trigger触发器，设置该任务立即执行，每2秒执行一次		                                                                        
		Trigger trigger = TriggerBuilder.newTrigger()
				          //设置组名，可以和jobDetail同名
				.withIdentity("myTrigger", "group1")
				  //立即执行
				.startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule()
						//每2秒执行一次                                            重复3次
						.withIntervalInSeconds(2).withRepeatCount(3)).build();
		
        //创建Scheduler调度器工厂
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();

		try {
			//创建Scheduler调度器
			Scheduler scheduler = schedulerFactory.getScheduler();
						
			//把 任务 和 触发器 绑定，开始调度
			scheduler.scheduleJob(jobDetail, trigger);
			
			//打印当前的执行的时间
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String nowDate  = f.format(date);
			System.out.println("定时任务启动:"+nowDate);
			
            //启动定时任务  
            if (!scheduler.isShutdown()) { 
            	scheduler.start();  
            }  
		} catch (SchedulerException e) {
			e.printStackTrace();
		}





	}

}
