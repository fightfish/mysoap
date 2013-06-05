package webservice;

import java.util.Vector;

import org.apache.soap.rpc.Parameter;

import device.Driver;

public class Moves {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String Two(String x, String y) throws Exception{
		String ourUrn = "Third";
		String ourMethod = "sayHi";
		Vector params = new Vector();
		params.addElement(new Parameter("ourName", String.class, x, null));
		   
		params.addElement(new Parameter("yourName", String.class, y, null));
		   
		Driver d = new Driver(ourUrn, ourMethod, params);
		
		
		return d.result() + "";
	}
}
