package net.lovememo.euler.Problem26_50;

import java.util.ArrayList;
import java.util.Iterator;

import net.lovememo.euler.util.EulerUtil;

public class Problem37 {
	
	private static long[] getTruncatableNumbers(long num) {
		long[] TruncatableNumbers = null;
		long[] digits = EulerUtil.numberToArray(num);
		int truncatableNumberLocation = 0;
		
		if(digits.length>0)
			TruncatableNumbers = new long[(digits.length-1)*2+1];
		else 
			return null;
		
		for(int i=1; i<digits.length; i++) {			
			long[] tmpArr1 = new long[digits.length-i];
			long[] tmpArr2 = new long[digits.length-i];
			
			for(int j=0; j<tmpArr1.length; j++) {
				tmpArr1[j] = digits[j+i];
			}
			
			for(int j=tmpArr2.length-1; j>=0; j--) {
				tmpArr2[j] = digits[j];
			}
			
			long tmpNum = EulerUtil.arrayToNumber(tmpArr1);
			TruncatableNumbers[truncatableNumberLocation] = tmpNum;
			truncatableNumberLocation ++;
			tmpNum = EulerUtil.arrayToNumber(tmpArr2);
			TruncatableNumbers[truncatableNumberLocation] = tmpNum;
			truncatableNumberLocation ++;
		}
		
		TruncatableNumbers[truncatableNumberLocation] = num;
		
		
		return TruncatableNumbers;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> numbers = EulerUtil.getPrimesBelow(1000000);
		Iterator<Integer> it = numbers.iterator();
		int count = 0;
		int sum = 0;
		while(it.hasNext()) {
			int tmpNum = it.next();
			long[] nums = getTruncatableNumbers(tmpNum);
			boolean flag = true;
			for(int i=0; i<nums.length; i++) {
				if(!EulerUtil.isPrime(nums[i])) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				if(tmpNum!=3&&tmpNum!=5&&tmpNum!=7&&tmpNum!=2) {
					//System.out.println(tmpNum);
					sum += tmpNum;
					count ++;
				}
			}
			if(count == 11){
				System.out.println("sum: "+sum);
				break;
			}
		}
		
		System.out.println("counts: " + (count));
		
//		long[] nums = getTruncatableNumbers(73331);
//		for(int i=0; i<nums.length; i++) {
//			System.out.print(nums[i] + " ");
//		}
		
		
		System.out.println();
		
		long endTime = System.currentTimeMillis();
		System.out.println("Used Time: " + (endTime - startTime) + "ms");
	}

}
