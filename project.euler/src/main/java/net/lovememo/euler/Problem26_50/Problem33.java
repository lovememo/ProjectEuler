package net.lovememo.euler.Problem26_50;

public class Problem33 {

	public static int[] getSimplifiedFraction(int a, int b) { //[0]����a  [1]��ĸb
		int[] num = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		for(int i=0; i<num.length; i++) {
			if(a<num[i] || b<num[i]) 
				break;
			
			while(a%num[i]==0 && b%num[i]==0) {
				a /= num[i];
				b /= num[i];
			}
		}
		int[] array = new int[2];		
		array[0] = a;
		array[1] = b;
		return array;
	}
	
	public static int[] getDigits(int a) {
		int[] array = new int[2];
		array[1] = a / 10;
		array[0] = a - array[1] * 10;
		return array;
	}
	
	public static int[] getIncorrectFraction(int a, int b) {
		int[] top = new int[2];
		int[] bottom = new int[2];
		int[] array = {a,b};
		top = getDigits(a);
		bottom = getDigits(b);
		
		for(int i=0; i<top.length; i++) {
			for(int j=0; j<bottom.length; j++) {
				if(top[i] == bottom[j]) {
					array[0] = top[(i+1)%2];
					array[1] = bottom[(j+1)%2];
					break;
				}
			}
		}
		
		return getSimplifiedFraction(array[0],array[1]);
	}
	
	public static boolean canGetIncorrectFraction(int a, int b) {
		int[] top = new int[2];
		int[] bottom = new int[2];
		top = getDigits(a);
		bottom = getDigits(b);
		
		for(int i=0; i<top.length; i++) {
			for(int j=0; j<bottom.length; j++) {
				if(top[i] == bottom[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean equalToEachOther(int a[], int[]b) {
		for(int i=0; i<a.length; i++) {
			if(a[i] != b[i])
				return false;
		}
		return true;
	}
	
	public static void printFraction(int[] a) {
		System.out.print(a[0]+"/"+a[1]);
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int sum = 0;
		for(int top=11; top<=99; top++) {
			for(int bottom=11; bottom<=99; bottom++) {
				if(bottom <= top || top%10==0 || !canGetIncorrectFraction(top, bottom))
					continue;
				int a[] = getSimplifiedFraction(top,bottom);
				int b[] = getIncorrectFraction(top,bottom);
				
				if(equalToEachOther(a,b)) {
					System.out.print("a:"+top+" b:"+bottom+", ");
					printFraction(a);
					System.out.println();
					sum ++;
				}
			}
		}
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (endTime - startTime) + "ms");
	}
}
