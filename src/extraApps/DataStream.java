package extraApps;

import java.io.IOException;
import java.util.List;
public interface DataStream {
	public String setDataStream(String string) throws IOException;
	public int setDataStream(int i) throws IOException;
	public double setDataStream(double d) throws IOException;
	public long setDataStream(long d) throws IOException;
	public String[] setDataStream(String[] d) throws IOException;
	public int[] setDataStream(int[] d) throws IOException;
	public double[] setDataStream(double[] d) throws IOException;
	public long[] setDataStream(long[] d) throws IOException;
	public List<String> setStringList(List<String> list)throws IOException;
	public List<Integer> setIntegerList(List<Integer> list)throws IOException;
	public List<Long> setLongList(List<Long> list)throws IOException;
	public List<Double> setDoubleList(List<Double> list)throws IOException;

}