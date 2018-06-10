package net.lovememo.euler.Problem26_50;

import net.lovememo.euler.util.EulerUtil;

public class Problem46 {

	/**
	 *��ȡ������б�
	 *@author Lovememo 
	 */
	private static Integer[] getOddCompositeNumArr(Integer[] primeArr) {
		Integer[] oddCompositeNumArr = new Integer[primeArr.length];
		int count = 0;
		int n = 1;
		int oddNum = 1;
		while(count<primeArr.length) {
			oddNum = 2 * n + 1;
			if(!EulerUtil.binarySearch(primeArr, oddNum, 0, primeArr.length)) {
				oddCompositeNumArr[count ++] = oddNum;
			}			
			n ++;
		}
		
		return oddCompositeNumArr;
	}
	
	/**
	 * �ж�[һ�������]�ܷ񱻱�ʾ��[һ������]��[����ƽ����]�ĺ�
	 * @param oddNum
	 * @param primeNumArr
	 * @return
	 */
	private static boolean detect(int oddNum, Integer[] primeNumArr) {
		int primeNum = 2;
		int tmpNum = -1;
		for(int i=0; i<primeNumArr.length; i++) {
			primeNum = primeNumArr[i];
			if(primeNum >= oddNum)
				return false;
			tmpNum = oddNum - primeNum;
			if(!EulerUtil.isEvenNum(tmpNum)) //�������ȥ�������ж��Ƿ�Ϊż��
				continue;
			tmpNum /= 2;
			if(!EulerUtil.isTwiceSquareNum(tmpNum)) //�Ƿ�Ϊƽ����
				continue;
			System.out.println(oddNum + " = " + primeNum + " + 2 * " + (int)Math.sqrt(tmpNum) + "^2");
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int _length = 10000;
		Integer[] primeNumArr = new Integer[_length];//10000������
		Integer[] oddCompositeNumArr;//10000�������
		
		EulerUtil.getPrimesSizeof(_length).toArray(primeNumArr);
		oddCompositeNumArr = getOddCompositeNumArr(primeNumArr);
		
		int oddNum = 1;
		for(int i=0; i<oddCompositeNumArr.length; i++) {
			oddNum = oddCompositeNumArr[i];
			if(!detect(oddNum, primeNumArr)) {
				System.out.println(oddNum + " can not calc!");
				break;
			}
		}		
		
		long endTime = System.currentTimeMillis();
		System.out.println("Used Time: " + (endTime - startTime) + "ms");
	}

}
