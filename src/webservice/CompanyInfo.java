package webservice;

import interfaces.CompanyInfoDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CompanyInfo {
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		CompanyInfoDefinition companyInfodefinition = (CompanyInfoDefinition) o;
		return companyInfodefinition.getResult();
	}
}
