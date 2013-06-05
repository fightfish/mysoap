package extraApps;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InputMethod extends DataInputStream implements DataStream{

	public InputMethod(InputStream in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	public String setDataStream(String string) throws IOException {
		return readUTF();
	}
	public int setDataStream(int i) throws IOException {
		// TODO Auto-generated method stub
		return readInt();
	}

	public double setDataStream(double d) throws IOException {
		// TODO Auto-generated method stub
		return readDouble();
	}

	public long setDataStream(long d) throws IOException {
		// TODO Auto-generated method stub
		return readLong();
	}
	public String[] setDataStream(String[] d) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		String[] array=new String[size];
		for (int i = 0; i < size; i++) {
			array[i]=readUTF();
		}
		return array;
	}
	
	public int[] setDataStream(int[] d) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		int[] array=new int[size];
		for (int i = 0; i < size; i++) {
			array[i]=readInt();
		}
		return array;
	}

	public double[] setDataStream(double[] d) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		double[] array=new double[size];
		for (int i = 0; i < size; i++) {
			array[i]=readDouble();
		}
		return array;
	}

	public long[] setDataStream(long[] d) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		long[] array=new long[size];
		for (int i = 0; i < size; i++) {
			array[i]=readLong();
		}
		return array;
	}

	public List<String> setStringList(List<String> list) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		for (int i = 0; i < size; i++) {
			list.add(readUTF());
		}
		return list;
	}

	public List<Integer> setIntegerList(List<Integer> list) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		for (int i = 0; i < size; i++) {
			list.add(readInt());
		}
		return list;
	}

	public List<Long> setLongList(List<Long> list) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		for (int i = 0; i < size; i++) {
			list.add(readLong());
		}
		return list;
	}

	public List<Double> setDoubleList(List<Double> list) throws IOException {
		// TODO Auto-generated method stub
		int size=readInt();
		for (int i = 0; i < size; i++) {
			list.add(readDouble());
		}
		return list;
	}
}
