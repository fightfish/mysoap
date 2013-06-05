package extraApps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class OutputMethod extends DataOutputStream implements DataStream{
	
	public OutputMethod(OutputStream out) {
		super(out);
	}

	public String setDataStream(String string) throws IOException {
		writeUTF(string);
		return string;
	}

	public int setDataStream(int i) throws IOException {
		// TODO Auto-generated method stub
		writeInt(i);
		return i;
	}

	public double setDataStream(double d) throws IOException {
		// TODO Auto-generated method stub
		writeDouble(d);
		return d;
	}

	public long setDataStream(long d) throws IOException {
		// TODO Auto-generated method stub
		writeLong(d);
		return d;
	}
	
	public String[] setDataStream(String[] d) throws IOException {
		// TODO Auto-generated method stub
		writeInt(d.length);
		for (int i = 0; i < d.length; i++) {
			setDataStream(d[i]);
		}
		return d;
	}

	public int[] setDataStream(int[] d) throws IOException {
		// TODO Auto-generated method stub
		writeInt(d.length);
		for (int i = 0; i < d.length; i++) {
			setDataStream(d[i]);
		}
		return d;
	}

	public double[] setDataStream(double[] d) throws IOException {
		// TODO Auto-generated method stub
		writeInt(d.length);
		for (int i = 0; i < d.length; i++) {
			setDataStream(d[i]);
		}
		return d;
	}

	public long[] setDataStream(long[] d) throws IOException {
		// TODO Auto-generated method stub
		writeInt(d.length);
		for (int i = 0; i < d.length; i++) {
			setDataStream(d[i]);
		}
		return d;
	}

	public List<String> setStringList(List<String> list) throws IOException{
		// TODO Auto-generated method stub
		writeInt(list.size());
		for (int i = 0; i < list.size(); i++) {
			setDataStream(list.get(i));
		}
		return list;
	}

	public List<Integer> setIntegerList(List<Integer> list) throws IOException{
		// TODO Auto-generated method stub
		writeInt(list.size());
		for (int i = 0; i < list.size(); i++) {
			setDataStream(list.get(i));
		}
		return list;
	}

	public List<Long> setLongList(List<Long> list) throws IOException{
		// TODO Auto-generated method stub
		writeInt(list.size());
		for (int i = 0; i < list.size(); i++) {
			setDataStream(list.get(i));
		}
		return list;
	}

	public List<Double> setDoubleList(List<Double> list) throws IOException{
		// TODO Auto-generated method stub
		writeInt(list.size());
		for (int i = 0; i < list.size(); i++) {
			setDataStream(list.get(i));
		}
		return list;
	}
	
}
