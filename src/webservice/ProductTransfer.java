package webservice;

import interfaces.StorageTransferDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProductTransfer {
	@SuppressWarnings("rawtypes")
	Constructor c;
	Object o;
	public byte[] ksoap(String classname, byte[] by) throws SecurityException, 
		NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, 
		InstantiationException, IllegalAccessException, InvocationTargetException{
		
		c = Class.forName(classname).getConstructor(byte[].class);
		o = c.newInstance(new Object[]{by});
		StorageTransferDefinition storagetransferdefinition = (StorageTransferDefinition) o;
		return storagetransferdefinition.getResult();
	}
}
