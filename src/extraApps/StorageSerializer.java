package extraApps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import model.StorageModel;

public class StorageSerializer {

	public byte[] serialize(StorageModel[] dh) throws IOException{
		ByteArrayOutputStream baos = new
			ByteArrayOutputStream();
		DataOutputStream dos = new
			DataOutputStream(baos);
		dos.writeInt(dh.length);
		for (int i = 0; i < dh.length; i++)
		{
			dos.writeUTF(dh[i].getString1());
			dos.writeUTF(dh[i].getString2());
			dos.writeUTF(dh[i].getString3());
			dos.writeUTF(dh[i].getString4());
			dos.writeUTF(dh[i].getString5());
			dos.writeUTF(dh[i].getString6());
			dos.writeInt(dh[i].getInt());
			dos.writeDouble(dh[i].getDouble());
		}
		baos.close();
		dos.close();
		
		return baos.toByteArray();
	}
	
	public StorageModel[] deserialize(byte[] data) throws IOException{
		ByteArrayInputStream bais = new 
			ByteArrayInputStream(data);
		DataInputStream dis = new 
			DataInputStream(bais);
		
		int t = dis.readInt();
		StorageModel[] dh = new StorageModel[t];
		
		for (int i = 0; i < dh.length; i++)
		{
			dh[i] = new StorageModel();
			dh[i].setString1(dis.readUTF());
			dh[i].setString2(dis.readUTF());
			dh[i].setString3(dis.readUTF());
			dh[i].setString4(dis.readUTF());
			dh[i].setString5(dis.readUTF());
			dh[i].setString6(dis.readUTF());
			dh[i].setInt(dis.readInt());
			dh[i].setDouble(dis.readDouble());
		}
		bais.close();
		dis.close();
		return dh;
	}
}
