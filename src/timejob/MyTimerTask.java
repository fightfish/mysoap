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
        
		  /*** ����ÿ��1:00ִ�з��� ***/
		 
		  calendar.set(Calendar.HOUR_OF_DAY, 1);
		  calendar.set(Calendar.MINUTE, 0);
		  calendar.set(Calendar.SECOND, 0);
		   
		  date = calendar.getTime(); //��һ��ִ�ж�ʱ�����ʱ��
		   
		  //�����һ��ִ�ж�ʱ�����ʱ�� С�� ��ǰ��ʱ��
		  //��ʱҪ�� ��һ��ִ�ж�ʱ�����ʱ�� ��һ�죬�Ա���������¸�ʱ���ִ�С��������һ�죬���������ִ�С�
		  if (date.before(new Date())) {
		      date = this.addDay(date, 1);
		  }
	}
	
	//ʱ����
	 private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

	
	public void contextDestroyed(ServletContextEvent event) {   
		// TODO Auto-generated method stub   
		timer.cancel();
		event.getServletContext().log("��ʱ��������");   
		System.out.println("ֹͣ��ʱ���򡭡�");   
	}

	public void contextInitialized(ServletContextEvent event) {   
		//�������ʼ������������tomcat������ʱ�����������������,����ʾ����������ʵ�ֶ�ʱ������  
		
		
		timer = new Timer();
		event.getServletContext().log("��ʱ����������");//�����־������tomcat��־�в鿴��  
		
		timer.schedule(new exportHistoryBean(event.getServletContext()), date, PERIOD_DAY);
		//���� exportHistoryBean��0��ʾ�������ӳ٣�5*1000��ʾÿ��5��ִ������60*60*1000��ʾһ��Сʱ��   
	}
	
	public Date addDay(Date date, int num){
		  Calendar startDT = Calendar.getInstance();
		  startDT.setTime(date);
		  startDT.add(Calendar.DAY_OF_MONTH, num);
		  return startDT.getTime();
	}
}
