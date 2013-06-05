package discount;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;

import model.SellModel;

public class OrderService {
	
	private FileChannel fc;
	private FileLock flock;
	private int size;
	
	private RandomAccessFile RAFile;
	private MappedByteBuffer mapBuf;
	
	private void initialize(String name) throws IOException{
		//new File("intent/" + dh.getString1()).delete();
		RAFile = new RandomAccessFile("intent/" + name, "rw");
		fc = RAFile.getChannel();
		flock = fc.tryLock();
		size = (int)fc.size();
	}
	
	public OrderService(SellModel m) throws IOException{
		initialize(m.getString1());
		
		if(flock == null) {
			System.out.println("possessed");
		} else {
			mapBuf = fc.map(FileChannel.MapMode.READ_WRITE, size, 120);
			
			mapBuf.putInt(m.getInt());
			
			String str = m.getString2();
			char[] ch = str.toCharArray();
			for (int i = 0; i < ch.length; i++)
				mapBuf.putChar(ch[i]);
			mapBuf.position(52);
			
			str = m.getString3();
			ch = str.toCharArray();
			for (int i = 0; i < ch.length; i++)
				mapBuf.putChar(ch[i]);
			mapBuf.position(100);
			
			str = m.getString4();
			ch = str.toCharArray();
			for (int i = 0; (i < ch.length) && (i < 10); i++)
				mapBuf.putChar(ch[i]);
			
			size += 120;
		}
	}
	
	public OrderService(String name, int id) throws IOException{
		initialize(name);
		mapBuf = fc.map(FileChannel.MapMode.READ_WRITE, 0, size);
		
		int t = size / 120;
		
		for (int i = 0; i < t; i++)
		if (mapBuf.getInt() == id){
			mapBuf.position(i * 120);
			mapBuf.putInt(0);
			break;
		}
	}
	
	public ArrayList<SellModel> getIntent() throws IOException{
		mapBuf = fc.map(FileChannel.MapMode.READ_WRITE, 0, size);
		
		int t = size / 120;
		ArrayList<SellModel> m = new ArrayList<SellModel>();
		SellModel sm;
		
		for (int i = 1; i <= t; i++)
		if (mapBuf.getInt() > 0){
			sm = new SellModel();
			String str = "";
			for (int j = 0; j < 24; j++){
				char ch = mapBuf.getChar();
				if (ch != '\0') str += ch; else break;
			}
			sm.setString1(str);
			
			str = "";
			for (int j = 0; j < 24; j++){
				char ch = mapBuf.getChar();
				if (ch != '\0') str += ch; else break;
			}
			sm.setString2(str);
			
			str = "";
			for (int j = 0; j < 11; j++){
				char ch = mapBuf.getChar();
				if (ch != '\0') str += ch; else break;
			}
			sm.setString3(str);
			
			m.add(sm);
		} else if (i < t) mapBuf.position(i * 120);
		
		return m;
	}
}
