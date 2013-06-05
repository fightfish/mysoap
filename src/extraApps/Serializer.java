package extraApps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class Serializer {
	
	protected abstract void setData(DataStream dataStream) throws IOException;
	
	public Serializer(byte[] data){
		deserialize(data);
	}
	
	public Serializer(){};
	
	public byte[] serialize(){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputMethod dos = new OutputMethod(baos);
		
		try{
			setData(dos);
		} catch (IOException exc){
			exc.printStackTrace();
		}
		try {
			baos.close();
			dos.close();
		} catch (IOException e) {
		}
		
		return baos.toByteArray();
	}
	
	public void deserialize(byte[] data){
		ByteArrayInputStream bais = new ByteArrayInputStream(data);
		InputMethod dis = new InputMethod(bais);
		
		try{
			setData(dis);
		} catch (Exception exc){
		}
		try {
			bais.close();
			dis.close();
		} catch (IOException e) {
		}
	}
}