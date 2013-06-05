package exdatas;

import java.io.IOException;

import serializer.DataStream;


public class AcknowledgeDataOrderId extends AcknowlegeData{

	protected String orderid = "";
	
	public AcknowledgeDataOrderId(){
		
	}
	
	public AcknowledgeDataOrderId(byte[] by){
		deserialize(by);
	}
	
	public AcknowledgeDataOrderId(boolean ans, String id){
		if (ans) ack = 1; else ack = 0;
		orderid = id;
	}
	
	@Override
	protected void setData(DataStream dataStream) throws IOException {
		// TODO Auto-generated method stub
		super.setData(dataStream);
		orderid = dataStream.setDataStream(orderid);
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
}