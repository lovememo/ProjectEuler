package util.lovememo.net;

import java.math.BigInteger;
import java.util.ArrayList;





public class EulerUtil {
	private static ArrayList<Integer> primeList = new ArrayList<Integer>();	
	
	/*ȫ����ʱ�õ�*/
	private static int g_index = 0;
	
	/**
	 * ð������
	 */
	public static int[] bubbleSort (int[] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=i; j<array.length; j++) {
				if(array[j] < array[i]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		return array;
	}

	/**
	 * ����ȫ������
	 * @param m
	 * @param n
	 * @return P(m, n) (m>=n)
	 */
	public static int P(int m, int n) {
		int retVal = 1;
		for(int i=0; i<n; i++) {
			retVal *= (m--);
		}
		return retVal;
	}
	
	public static long C(int n, int r) {
		return Cmn.C(n, r);
	}
	/*��һ����תΪ����*/
	public static Integer[] number2Array(Integer num) {
		int arrLength = 0;
		int tmpNum = num;
		while(tmpNum != 0) {
			arrLength ++;
			tmpNum /= 10;
		}
		
		Integer[] retArr = new Integer[arrLength];
		tmpNum = num;
		int i = 0;
		while(tmpNum != 0) {
			retArr[i++] = tmpNum - tmpNum / 10 * 10;
			tmpNum /= 10;
		}
		
		
		return retArr;
	}
	public static Integer[] reverseNum(Integer[] num) {
		Integer[] retArr = num.clone();
		int max = retArr.length - 1;
		int mid = max / 2;
		for(int i=0; i<=mid; i++) {
			Integer tmp = retArr[i];
			retArr[i] = retArr[max-i];
			retArr[max-i] = tmp;
		}
		int zeroCount = 0;
		for(int i= retArr.length-1; i>=0; i--) {
			if(retArr[i]==0)
				zeroCount ++;
			else
				break;
		}
		int copyLen = retArr.length - zeroCount;
		if(zeroCount != 0 ) {
			Integer[] tmpArr = new Integer[copyLen];
			System.arraycopy(retArr, 0, tmpArr, 0, copyLen);
			retArr = tmpArr;
		}
		return retArr;
	}
	public static Integer[] getPower(int base, int num) {
		Integer[] retNum = EulerUtil.number2Array(base);
		for(int i=0; i<num-1; i++) {
			retNum = numberMultiplyNumber(retNum, base);
		}
		return retNum;
	}
	
	public static Integer[] numberMultiplyNumber(Integer[] numA, int numB) {
		Integer[] retNum = numA.clone();
		int preNum = 0;
		for(int i=0; i<retNum.length; i++) {
			retNum[i] *= numB;
		}
		
		for(int i=0; i<retNum.length; i++) {
			if(i==retNum.length -1 && retNum[i] >=10) {
				preNum = retNum[i] / 10;
				retNum[i] = retNum[i] - preNum * 10;
				break;
			}
			if(retNum[i] >= 10) {
				int tmpNum = retNum[i] / 10;
				retNum[i+1] += tmpNum; //��λ
				retNum[i] = retNum[i] - tmpNum * 10;
			}
		}
		if(preNum != 0) {
			Integer[] preNumArr = EulerUtil.number2Array(preNum);
			Integer[] tmpNumRet = new Integer[retNum.length + preNumArr.length];
			System.arraycopy(retNum, 0, tmpNumRet, 0, retNum.length);
			System.arraycopy(preNumArr, 0, tmpNumRet, retNum.length, preNumArr.length);
			retNum = tmpNumRet;
		}
		return retNum;
	}
	public static Integer[] numberAddNumber(Integer[] num1, Integer[] num2) {
		int preNum = 0;
		Integer[] shoterArr;
		Integer[] longerArr;
		if(num1.length > num2.length) {
			shoterArr = num2;
			longerArr = num1;
		} else {
			longerArr = num2;
			shoterArr = num1;
		}
		
		Integer[] tmpArr = new Integer[longerArr.length];
		for(int i=0; i<tmpArr.length; i++) {
			tmpArr[i] = 0;
		}
		for(int i=0; i<shoterArr.length; i++) {
			tmpArr[i] += (shoterArr[i] + longerArr[i]);
			if(tmpArr[i]>=10) {
				int tmp = (tmpArr[i] - tmpArr[i] / 10 * 10); 
				if(longerArr.length == shoterArr.length && i == shoterArr.length -1) {
					
					preNum = (tmpArr[i] - tmp)/10;
				} else {
					tmpArr[i+1] += (tmpArr[i] - tmp)/10;
				}
				tmpArr[i] = tmp;
			}
		}
		
		for(int i=shoterArr.length; i<longerArr.length; i++) {
			tmpArr[i] += longerArr[i];
			if(tmpArr[i]>=10) {
				int tmp = (tmpArr[i] - tmpArr[i] / 10 * 10); 
				if( i == longerArr.length -1) {
					preNum = (tmpArr[i] - tmp)/10;
				}else {
					tmpArr[i+1] += (tmpArr[i] - tmp)/10;
				}
				tmpArr[i] = tmp;
			}
		}
		
		Integer[] retArr;
		
		if(preNum !=0 ) {
			retArr = new Integer[longerArr.length + 1];
			System.arraycopy(tmpArr, 0, retArr, 0, longerArr.length);
			retArr[longerArr.length] = preNum;
			
		} else {
			retArr = tmpArr;
		}
		
		return retArr;
	}
	
	public static void main(String[] args) {
		System.out.println(C(4,2));
		/*int[][] ret = EulerUtil.getPermutation(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);
		
		for(int i=0; i<ret.length; i++) {
			System.out.print((i+1)+ "==>  ");
			for(int j=0; j<ret[i].length; j++) {
				System.out.print(ret[i][j] + " ");
			}
			System.out.println();
		}*/
	}
	
	/*
	 * ��ȡ���Լ��
	 * */
	public static int getGCD(int a, int b) {
		int min;
		int max;
		max = a >= b ? a : b;
		min = a + b - max;
		int remain = max%min;
		if(remain == 0)
			return min;
		return getGCD(min,remain);		
	}
	
	/**
	 * �ݹ�ȫ����
	 * @author Lovememo
	 * @param curStartIndex �ݹ����ʱ�ã�ʵ��ȫ���е��㷨���������Ԫ�أ�����Ǳ�־��ǰ����Ԫ����ŵġ�ָ�롱������ʱ����2����
	 * @param numberArr Ϊ�������Ҫȫ���е�����
	 * @param n Ϊ���ص���������ĳ��ȣ���������볤��Ϊ3�������г�ȡ2������Ԫ�������У���ʱ��n�������2
	 * @param retArr Ϊȫ���������ŵĵط�
	 * */
	private static void getPandigitalNums(int curStartIndex, int[] numberArr, int n, int[][] retArr) {
		if(curStartIndex == n) {
			int[] retSubArr = new int[n];
			System.arraycopy(numberArr, 0, retSubArr, 0, n);
			retArr[g_index++] = retSubArr;
			return;
		}
		
		for(int localIndex = curStartIndex; localIndex<numberArr.length; localIndex ++) {
			int[] newNum = numberArr.clone();
			int tmp = newNum[localIndex];
			newNum[localIndex] = newNum[curStartIndex];
			newNum[curStartIndex] = tmp;
			getPandigitalNums(curStartIndex + 1, newNum, n, retArr);
		}
	}
	
	
	
	/**
	 * ��ȡ�����������������
	 * @param arr ��������
	 * @param n   �������鳤��
	 * @return	    �������������
	 */
	public static int[][] getPermutation(int[] arr, int n) {
		g_index = 0;
		int m = arr.length;
		if(n<=0 || n>m)
			return null;
		int retArrLength = P(m, n);
		int[][] retArr = new int[retArrLength][n];
		getPandigitalNums(0, arr, n ,retArr);
		return retArr;
	}
	
	private static long startTime;
	public static long start() {
		EulerUtil.startTime = System.currentTimeMillis();
		return startTime;
	}
	
	public static void end(long s) {
		System.out.println("Time used: " + (System.currentTimeMillis() - s) + "���룡");
	}
	
	public static void end() {
		System.out.println("\r\nTime used: " + (System.currentTimeMillis() - startTime) + "���룡");
	}
	/**
	 * �ֽ�������
	 * @author Lovememo
	 */
	public static ArrayList getPrimeFactor(long num) {
		ArrayList factorList = new ArrayList();
		for(long i=2; i<num; i++) {
			if(num%i == 0) {
				factorList = getPrimeFactor(num/i);
				if(!factorList.contains(i))
					factorList.add(i);
				return factorList;
			}
		}
		factorList.add(num);
		return factorList;
	}
	
	/**
	 * �ж�һ�������ܷ񱻿���
	 * @author Lovememo
	 */
	public static boolean isTwiceSquareNum(int num) {
		int sqrtNum = (int) Math.sqrt(num);
		if(num == sqrtNum * sqrtNum)
			return true;
		else
			return false;
	}
	
	/**
	 * �ж�һ�������Ƿ�Ϊż��
	 * @author Lovememo
	 */
	public static boolean isEvenNum(int num) {
		int tmpNum = num / 2;
		if(num == tmpNum * 2)
			return true;
		else
			return false;
	}

	/**
	 * ���ֲ���
	 * @author Lovememo
	 * */
	public static boolean binarySearch(long[] array, long objNum, int startIndex,
			int endIndex) {
		if (endIndex < startIndex)
			return false;
		int midIndex = (startIndex + endIndex) / 2;
		long midNum = array[midIndex];
		if (midNum == objNum)
			return true;

		return objNum < midNum ? binarySearch(array, objNum, startIndex, midIndex - 1)
				: binarySearch(array, objNum, midIndex + 1, endIndex);
	}
	
	/**
	 * ���ֲ���
	 * @author Lovememo
	 * */
	public static boolean binarySearch(Integer[] array, int objNum, int startIndex,
			int endIndex) {
		if (endIndex < startIndex)
			return false;
		int midIndex = (startIndex + endIndex) / 2;
		long midNum = array[midIndex];
		if (midNum == objNum)
			return true;

		return objNum < midNum ? binarySearch(array, objNum, startIndex, midIndex - 1)
				: binarySearch(array, objNum, midIndex + 1, endIndex);
	}
	
	/**
	 * ���ֲ���
	 * @author Lovememo
	 * */
	public static boolean binarySearch(int[] array, int objNum, int startIndex,
			int endIndex) {
		if (endIndex < startIndex)
			return false;
		int midIndex = (startIndex + endIndex) / 2;
		long midNum = array[midIndex];
		if (midNum == objNum)
			return true;

		return objNum < midNum ? binarySearch(array, objNum, startIndex, midIndex - 1)
				: binarySearch(array, objNum, midIndex + 1, endIndex);
	}
	
	/**
	 * ��ȡС�ڵ���number�µ���������
	 * ����Ѿ����ù����������������ȡnumber�µ�����������ֱ�ӵ���getPrimeList()��ʡȥ���㲽�衣
	 * @author Lovememo
	 * */
	public static  ArrayList<Integer> getPrimesBelow(long number) {
		primeList = new ArrayList<Integer>();
		if(number < 2)
			return primeList;
		
		primeList.add(2);		
		for(int i=3; i<=number; i=i+2) {
			EulerUtil.calcPrime(i);
		}		
		return getPrimeList();
	}
	
	/**
	 * ��ȡnumber����������С����
	 * ����Ѿ����ù����������������ȡnumber��������ֱ�ӵ���getPrimeList()��ʡȥ���㲽�衣
	 * @author Lovememo
	 * */
	public static ArrayList<Integer> getPrimesSizeof(int number) {
		primeList = new ArrayList<Integer>();
		if(number < 1)
			return primeList;
		
		primeList.add(2);
		for(int i=3;EulerUtil.getPrimeList().size() != number;i=i+2) {
			EulerUtil.calcPrime(i);
		}
		
		return primeList;
	}
	
	public static boolean isPrime(long num) {
		
		if(num == 2)
			return true;
		if(num < 2)
			return false;
		if(primeList.size()==0) {
			getPrimesBelow(num);
			if(num == primeList.get(primeList.size()-1))
				return true;
			return false;
		}
		
		if(num == primeList.get(primeList.size()-1))
			return true;
		else if(num <primeList.get(primeList.size()-1)) {
			int midNum = (int)Math.sqrt(num);
			for(int i=0; i<primeList.size(); i++) {
				int prime = (Integer)primeList.get(i);
				if(num%prime == 0)
					return false;	
				if(prime > midNum)
					break;
			}
			return true;
		}
		else {
			getPrimesBelow(num);
			if(num == primeList.get(primeList.size()-1))
				return true;			
		}
		return false;
	}
	
	private static boolean calcPrime(int num) {
		int midNum = (int)Math.sqrt(num);
		for(int i=0; i<primeList.size(); i++) {
			int prime = (Integer)primeList.get(i);
			if(num%prime == 0)
				return false;	
			if(prime > midNum)
				break;
		}
		primeList.add(num);
		return true;
	}
	
	public static ArrayList<Integer> getPrimeList() {
		return primeList;
	}
	
	public static long arrayToNumber(long[] arr) {
		long retNum = 0;		
		for(int i=0; i<arr.length; i++) {
			retNum += (long)arr[i] * (long)getTenDigits(i);
		}
		return retNum;
	}	
	
	private static int getTenDigits(int count) {
		int retNum = 1;
		for(int i=0; i<count; i++) {
			retNum *= 10;
		}
		return retNum;
	}
	
	private static int getDigitNum(long number) {
		if(number == 0) 
			return 1;
		int digitNum = 0;
		while(number != 0) {
			number /= 10;
			digitNum ++;
		}
		return digitNum;
	}

	/**
	 *����һ������λ��ֵ������������
	 * */
	public static long[] numberToArray(long number) {
		int digitNumber = getDigitNum(number);
		long[] digits = new long[digitNumber];
		
		for(int i=0; i<digitNumber; i++) {
			digits[i] = number - number/10*10;
			number /= 10;
		}
		
		return digits;
	}
	
	
}
