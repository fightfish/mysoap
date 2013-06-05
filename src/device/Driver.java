package device;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.SOAPException;
import org.apache.soap.encoding.SOAPMappingRegistry;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

public class Driver {

	URL url = null;
	Response rep = null;
	Call c = null;
	 
	@SuppressWarnings("rawtypes")
	public Driver(String id, String method, Vector params) throws MalformedURLException, SOAPException{
			url = new URL("http://localhost:8080/mysoap/servlet/rpcrouter");
			c = new Call();
			c.setTargetObjectURI(id);
			c.setMethodName(method);
			c.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
			
			c.setParams(params);
		    
		    
			//System.out.println("and its answer is: ");
			rep = c.invoke(url, "");
	}
	
	public void setMaps(SOAPMappingRegistry smr){
		c.setSOAPMappingRegistry(smr);
	}
	
	public Object result(){
		Object o = "result failed";
		if (rep.generatedFault()) {
			   Fault fault = rep.getFault();
			   System.out.println("\nCall failed!");
			   System.out.println("Code = " + fault.getFaultCode());
			   System.out.println("String = " + fault.getFaultString());
			   return o;
		   } else {
			   Parameter result = rep.getReturnValue();
			   
			   return(result.getValue());
			   
		   }
	}
}
