package Problem26_50;

import java.util.ArrayList;
import java.util.Arrays;

import util.lovememo.net.EulerUtil;

public class Problem49 {
	
	/*获取四位质数数组*/
	private static Integer[] get4digitPrime() {
		ArrayList<Integer> primeList = EulerUtil.getPrimesBelow(10000);
		Integer[] primeArr = new Integer[primeList.size()];
		primeList.toArray(primeArr);
		
		int startIndex = 0;
		for(int i=0; i<primeArr.length; i++) {
			if(primeArr[i]>999) {
				startIndex = i;
				break;
			}
		}
		
		Integer[] retArr = new Integer[primeArr.length - startIndex];
		
		System.arraycopy(primeArr, startIndex, retArr, 0, primeArr.length - startIndex);	
		
		return retArr;
	}

	/* 获取四位全排列奇数 
	private static int[] get4digitPermutaionNum() {
		int[] tmpRetArr = new int[EulerUtil.P(10, 4) - EulerUtil.P(9, 3)];
		int[][] tmpArr = EulerUtil.getPermutation(new int[] { 0, 1, 2, 3, 4, 5,
				6, 7, 8, 9 }, 4);
		int retArrLength = 0;
		for (int i = 0; i < tmpArr.length; i++) {
			int[] rowArr = tmpArr[i];
			if (rowArr[3] == 0 || EulerUtil.isEvenNum(rowArr[0]))
				continue;
			tmpRetArr[retArrLength++] = rowArr[3] * 1000 + rowArr[2] * 100
					+ rowArr[1] * 10 + rowArr[0];
		}
		int[] retArr = new int[retArrLength];
		System.arraycopy(tmpRetArr, 0, retArr, 0, retArrLength);
		return retArr;
	}

	 获取四位全排列质数 
	private static int[] get4digitPermutationPrime() {
		int[] tmpArr = get4digitPermutaionNum();
		int[] tmpRetArr = new int[tmpArr.length];
		int retArrLength = 0;
		EulerUtil.getPrimesBelow(10000);

		for (int i = 0; i < tmpArr.length; i++) {
			int num = tmpArr[i];
			if (EulerUtil.isPrime(num))
				tmpRetArr[retArrLength++] = num;
		}
		int[] retArr = new int[retArrLength];
		System.arraycopy(tmpRetArr, 0, retArr, 0, retArrLength);
		Arrays.sort(retArr);//快速排序O(nlgn)
		return retArr;
	}*/
	
	/**
	 * 三个四位数是否有相同的digits 
	 */
	private static boolean hasSame4Digits(int a, int b, int c) {
		int[] signsA = new int[10];
		int[] signsB = new int[10];
		int[] signsC = new int[10];
		
		setSigns(a, signsA);
		if(!judgeOnce(signsA))
			return false;
		setSigns(b, signsB);
		if(!judgeOnce(signsB))
			return false;
		setSigns(c, signsC);
		if(!judgeOnce(signsC))
			return false;
		
		if(!Arrays.equals(signsA, signsB) || !Arrays.equals(signsB, signsC))
			return false;
		return true;
	}
	
	private static boolean judgeOnce(int[] signs) {		
		int sum = 0;
		for(int i=0; i<signs.length; i++) {
			sum += signs[i];
		}
		if(sum != 3)
			return false;
		else 
			return true;
	}
	
	private static void setSigns(int num, int[] signs) {
		int digit = 0;
		while(num != 0) {
			digit = num - num/10*10;
			signs[digit] = 1;
			num /= 10;
		}
	}

	public static void searchAnswer() {
		Integer[] arr = get4digitPrime();
		/*ArrayList<Integer> primeList = EulerUtil.getPrimesBelow(10000);
		Integer[] primeArr = new Integer[primeList.size()];
		primeList.toArray(primeArr);*/
		
		for (int i = 0; i < arr.length; i++) {
			for(int k=1; k<10000; k++) {
				int objNum = arr[i];
				int objNum2 = objNum + k;
				int objNum3 = objNum2 + k;
				if(EulerUtil.binarySearch(arr, objNum2, 0, arr.length-1)
						&& EulerUtil.binarySearch(arr, objNum3, 0, arr.length-1)
						&& hasSame4Digits(objNum, objNum2, objNum3)
						) {
					System.out.println(objNum+""+objNum2+""+objNum3);
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long s = EulerUtil.start();
		searchAnswer();
		
		EulerUtil.end(s);
	}

}
