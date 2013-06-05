package device;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Decode {
	
	ArrayList<ArrayList<String>> datas;
	ArrayList<String> row;
	
	public ArrayList<ArrayList<String>> getContents(String data){
		datas = new ArrayList<ArrayList<String>>();
		StringTokenizer fenxi = new StringTokenizer(data, "#");
		while(fenxi.hasMoreTokens()){
			row = new ArrayList<String>();
			String str=fenxi.nextToken();
			StringTokenizer fenxi2 = new StringTokenizer(str, "$");
			while (fenxi2.hasMoreTokens())
				row.add(fenxi2.nextToken());
			datas.add(row);
		}
		
		return datas;
	}
	
	public ArrayList<String> getLine(String data){
		row = new ArrayList<String>();
		StringTokenizer fenxi = new StringTokenizer(data, "#");
		while(fenxi.hasMoreTokens())
			row.add(fenxi.nextToken());
		return row;
	}
}