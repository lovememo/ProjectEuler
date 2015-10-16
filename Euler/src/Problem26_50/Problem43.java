package Problem26_50;

import java.util.ArrayList;
import java.util.List;

public class Problem43 {
	
	private static void printlnArr(int[] numArr) {
		for(int i=0; i<numArr.length; i++) {
			System.out.print(numArr[i]);
		}
		System.out.println();
	}
	
	private static int getNumFromArr(int index, int[]numberArr) {
		int retNum = 0;
		retNum += numberArr[index] * 100;
		retNum += numberArr[index+1] * 10;
		retNum += numberArr[index+2] ;
		return retNum;
	}
	
	private static void checkNum(int[] numberArr) {
		if(numberArr[0] == 0)
			return;
		int[] divider = {2,3,5,7,11,13,17}; 
		for(int i=1; i<numberArr.length-2; i++) {
			int tmp = getNumFromArr(i, numberArr);
			if(tmp%divider[i-1] !=0)
				return;
		}
		printlnArr(numberArr);
	}
	
	/*µÝ¹éÈ«ÅÅÁÐ*/
	private static void getPandigitalNums(int curStartIndex, int[] numberArr) {
		if(curStartIndex == numberArr.length-1) {
			checkNum(numberArr);
			return;
		}
		for(int localIndex = curStartIndex; localIndex<numberArr.length; localIndex ++) {
			int[] newNum = numberArr.clone();
			int tmp = newNum[localIndex];
			newNum[localIndex] = newNum[curStartIndex];
			newNum[curStartIndex] = tmp;
			getPandigitalNums(curStartIndex + 1, newNum);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1,0,2,3,4,5,6,7,8,9};
		getPandigitalNums(0,a);
		System.out.println("done");
	}

}
