package exdatas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import serializer.DataStream;
import serializer.Serializer;

public class ProductTypeListData extends Serializer{

	List<String> type = new ArrayList<String>();
	
	public ProductTypeListData() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductTypeListData(List<String> t) {
		// TODO Auto-generated constructor stub
		type = t;
	}
	
	public ProductTypeListData(byte[] by) {
		deserialize(by);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setData(DataStream dataStream) throws IOException {
		// TODO Auto-generated method stub
		type = dataStream.setStringList(type);
	}
	
	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}
}
