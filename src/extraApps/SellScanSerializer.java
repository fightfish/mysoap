package extraApps;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import model.SellModel;


public class SellScanSerializer {

	public byte[] serialize(SellModel dh){
		ByteArrayOutputStream baos = new
			ByteArrayOutputStream();
		DataOutputStream dos = new
			DataOutputStream(baos);
		
		try{
			dos.writeUTF(dh.getString1());
			dos.writeUTF(dh.getString2());
			dos.writeUTF(dh.getString3());
			dos.writeUTF(dh.getString4());
			dos.writeUTF(dh.getString5());
			dos.writeInt(dh.getInt());
			dos.writeDouble(dh.getDouble());
			baos.close();
			dos.close();
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
		return baos.toByteArray();
	}
	
	public void deserialize(SellModel dh, byte[] data){
		ByteArrayInputStream bais = new 
			ByteArrayInputStream(data);
		DataInputStream dis = new 
			DataInputStream(bais);
		
		try{
			dh.setString1(dis.readUTF());
			dh.setString2(dis.readUTF());
			dh.setString3(dis.readUTF());
			dh.setString4(dis.readUTF());
			dh.setString5(dis.readUTF());
			dh.setInt(dis.readInt());
			dh.setDouble(dis.readDouble());
			bais.close();
			dis.close();
		} catch (Exception exc){}
	}
}
