package timejob;

import java.util.Calendar;
import java.util.TimerTask;   
import javax.servlet.ServletContext;   


import service.SumService;

public class exportHistoryBean extends TimerTask{   
	private ServletContext context = null;   
	
	public exportHistoryBean(ServletContext context)   {   
		this.context = context;
	}   

	@Override  
	public void run(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		int month = c.get(Calendar.MONTH) + 1;//得到月，因为从0开始的，所以要加1
		String m;
		if (month / 10 == 0) m = "0" + month; else m = "" + month;
		int day = c.get(Calendar.DAY_OF_MONTH);//得到天
		String d;
		if (day / 10 == 0) d = "0" + day; else d = "" + day;
		String timeString = c.get(Calendar.YEAR) + m + d;
		
		new SumService().getSubbranchSales(Long.parseLong(timeString));
		
	}   
}