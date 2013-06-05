package webservice;

import interfaces.AddUserDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AddUser {
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		AddUserDefinition adduserdefinition = (AddUserDefinition) o;
		return adduserdefinition.getResult();
	}
}
