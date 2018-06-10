package net.lovememo.euler.Problem26_50;

public class Problem39 {
	/**
	 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions 
	 * for p = 120.  {20,48,52}, {24,45,51}, {30,40,50} For which value of p �� 1000, is the number of solutions maximised?
	 */

	public static int getSolutionNum(int inputNum) {
		int retNum = 0;
		//get solution counts of a * a + b * b = (inputNum -a - b) * (inputNum -a - b);
		for(int i=1; i<inputNum / 2; i++) {
			for(int j=1; j<inputNum / 2; j++) {

				int k= inputNum - i - j;
				if(k < 0) 
					continue;
				if(i*i + j*j == k*k) {
					//System.out.println("{" + i + "," + j + "," + k + "}");
					retNum ++;
				}
			}
		}
		
		return retNum / 2;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 0;
		int cur = 0;
		int value = 0;
		for(int i=1; i<=1000; i++) {
			cur = getSolutionNum(i);
			if(cur > max) {
				max = cur;
				value = i;
			}
		}
		System.out.println("value:" +value+ " max:" + max);
	}

}
