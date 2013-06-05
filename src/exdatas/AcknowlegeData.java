package exdatas;

import java.io.IOException;

import serializer.DataStream;
import serializer.Serializer;

public class AcknowlegeData extends Serializer{

	protected int ack = 0;
	
	public AcknowlegeData(){
		
	}
	
	public AcknowlegeData(boolean boo){
		if (boo) ack = 1; else ack = 0;
	}
	
	public AcknowlegeData(byte[] by){
		deserialize(by);
	}
	
	@Override
	protected void setData(DataStream dataStream) throws IOException {
		// TODO Auto-generated method stub
		ack = dataStream.setDataStream(ack);
	}

	public boolean getAck() {
		if (ack == 1) return true;
		
		return false;
	}

	public void setAck(boolean boo) {
		if (boo) ack = 1; else ack = 0;
	}
}
