package Problem01_25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem22 {
	public static String[] getNames() throws IOException {
		File file = new File(System.getProperty("user.dir")+"/src/Problem1_25/names.txt");	
		BufferedReader br=new BufferedReader(new FileReader(file));
        String line=null;
        StringBuffer sb=new StringBuffer();
        line=br.readLine();
        while(line!=null){
            sb.append(line+" ");
            line=br.readLine();
        }
        br.close();
        return sb.toString().replace("\"","").replace(" ","").split(",");
	}
	
	public static int getValue(String name) {
		int value = 0;
		for(int i=0; i<name.length(); i++) {
			value += (int)name.charAt(i) - (int)'A' + 1;
		}
		return value;
	}

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		int score = 0;
		String[] names = getNames();		
		Arrays.sort(names);
		for(int i=1; i<=names.length; i++) {
			score += i * getValue(names[i-1]);
		}
		System.out.println(score);
        
		long endTime = System.currentTimeMillis();
		
		
		System.out.println("ÏûºÄÊ±¼ä£º " + (endTime - startTime) + "ms.");
		
	}

}
