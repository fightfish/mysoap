package timejob;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyTimerTask implements ServletContextListener{   
	
	private Timer timer = null; 
	private Calendar calendar;
	private Date date;
	
	public MyTimerTask(){
		calendar = Calendar.getInstance();
        
		  /*** 定制每日1:00执行方法 ***/
		 
		  calendar.set(Calendar.HOUR_OF_DAY, 1);
		  calendar.set(Calendar.MINUTE, 0);
		  calendar.set(Calendar.SECOND, 0);
		   
		  date = calendar.getTime(); //第一次执行定时任务的时间
		   
		  //如果第一次执行定时任务的时间 小于 当前的时间
		  //此时要在 第一次执行定时任务的时间 加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
		  if (date.before(new Date())) {
		      date = this.addDay(date, 1);
		  }
	}
	
	//时间间隔
	 private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

	
	public void contextDestroyed(ServletContextEvent event) {   
		// TODO Auto-generated method stub   
		timer.cancel();
		event.getServletContext().log("定时任务销毁");   
		System.out.println("停止定时程序……");   
	}

	public void contextInitialized(ServletContextEvent event) {   
		//在这里初始化监听器，在tomcat启动的时候监听器启动，考试,大提示可以在这里实现定时器功能  
		
		
		timer = new Timer();
		event.getServletContext().log("定时任务已启动");//添加日志，可在tomcat日志中查看到  
		
		timer.schedule(new exportHistoryBean(event.getServletContext()), date, PERIOD_DAY);
		//调用 exportHistoryBean，0表示任务无延迟，5*1000表示每隔5秒执行任务，60*60*1000表示一个小时；   
	}
	
	public Date addDay(Date date, int num){
		  Calendar startDT = Calendar.getInstance();
		  startDT.setTime(date);
		  startDT.add(Calendar.DAY_OF_MONTH, num);
		  return startDT.getTime();
	}
}
