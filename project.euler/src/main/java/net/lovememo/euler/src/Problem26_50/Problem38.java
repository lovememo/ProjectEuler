package Problem26_50;

import java.util.ArrayList;

public class Problem38 {
	
	public static ArrayList<Integer> getResults() {
		ArrayList<Integer> retList = new ArrayList<Integer>();
		int tmpLen = 9877;
		int currentMax = 111111111;
		for(int i=1; i<tmpLen; i++) {
			String tmpResult = "";
			
			for(int j=1; j<10; j++) {
				tmpResult += Integer.toString(i * j);
				if(isIllegal(tmpResult))
					break;
				else if(tmpResult.length() == 9) {
					Integer tmpInt = Integer.parseInt(tmpResult);
					
					if(tmpInt > currentMax) {
						retList.add(tmpInt);
						currentMax = tmpInt;
						System.out.println(i+" "+j+" "+currentMax);
					}
				}		
					
			}
		}
		return retList;
	}
	//非法
	private static boolean isIllegal(String tmpResult) {
		if(tmpResult.length() > 9)//长度判断
			return true;
		int[] mp = new int[9];
		for(int i=0; i<tmpResult.length(); i++) { //重复判断
			int index = Integer.parseInt(tmpResult.substring(i, i+1));
			if(index == 0)
				return true; //结果中有0，则为非法
			mp[index - 1] ++;
			if(mp[index - 1] > 1)
				return true;
		}		
		return false;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getResults();
		/*ArrayList<Integer> re = getResults();
		for(Integer result : re) {
			System.out.println(result);
		}*/
	}

}
