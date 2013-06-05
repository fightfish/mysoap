package webservice;

import model.HelloData;
import interfaces.DataHand;

  public class SOAPService {
	
	  public HelloData ksoap(String str){
		  HelloData hd = new HelloData();
		  hd.setString1("successed");
		  hd.setString2("successed");
		  return hd;
	  }
	  
	  public String input(DataHand hd){
		  return sayHi(hd.getString1(), hd.getString2());
	  }
	
    public String sayHi(String x, String y) {
    	
      return("Hello my friend, " + x + " and " + y + "! Glad to see you!");
    }
}