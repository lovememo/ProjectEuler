package Problem26_50;

import java.util.ArrayList;

import util.lovememo.net.EulerUtil;

public class Problem50 {
	
	public static int getSum(int startIdx, int endIdx, Integer[] arr) {
		int sum = 0;
		for(int i=startIdx; i<=endIdx; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void showArr(Integer[] arr) {
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	/**
	 * @param args
	 * 算法使用时间 1分钟左右
	 */
	public static void main(String[] args) {
		long s = EulerUtil.start();
		//构造质数表
		ArrayList<Integer> primeList = EulerUtil.getPrimesBelow(1000000);
		Integer[] primeArr = new Integer[primeList.size()];
		primeList.toArray(primeArr);
		
		int g_prime = 0;
		int maxLength = 0;
		int g_start = 0;
		int g_end = 0;
		
		/*从质数表最大的数开始，看每个质数能否由左端的质数字串和来表示（左端序号由0开始顺序递增）*/
		for(int i= primeArr.length-1; i>=0; i--) {
			int curPrime = primeArr[i];
			if(i<maxLength)
				break;
			for(int j=0; j<=i; j++) {
				if(i-j+1 <maxLength)
					break;
				int diff = curPrime;
				int k = j;
				while(diff > 0) {
					diff -= primeArr[k];
					k ++;
				}
				if(diff == 0 ) {
					int length = k - j;
					if(length > maxLength) {
						g_prime = curPrime;
						maxLength = length;
						g_start = j;
						g_end = k-1;
					}
				}
				
			}
			
		}
		System.out.println("ans: " + g_prime + " maxLength: " + maxLength + " start: " + g_start + " end: " + g_end);
				
		EulerUtil.end(s);
	}

}
