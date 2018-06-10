package net.lovememo.euler.Problem26_50;

public class Problem26 {
	public static int getLength(int[] reminder,int seq) {
		int sum = 1;
		int num = reminder[seq];
		for(int i=seq-1; i>0; i--) {
			if(reminder[i] != num)
				sum ++;
			else
				return sum;
		}
		return sum;
	}

	public static int getCycleLength(int num) {
		int[] cache = new int[1000];    //������һ������k����kλ��Ϊ1����λǰ�����жϵ�kλ�Ƿ�Ϊ1����Ϊ1��˵�����������ֹ�������ѭ����
		int NumberToBeDivided = 1;		
		int[] reminder = new int[1000]; //�������
		int i = 0;
		while((reminder[i] = NumberToBeDivided%num) != 0) {
			if(cache[reminder[i]] == 0) {
				cache[reminder[i]] = 1;
				NumberToBeDivided = reminder[i] * 10;	
				i ++;
			}
			else
				return getLength(reminder, i);	
		}
		return 0;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		int maxCycleLength = 0;
		int tmp = 0;
		int num = 0;
		for(int i=1; i<1000; i++) {
			tmp = getCycleLength(i);
			if(tmp>maxCycleLength) {
				maxCycleLength = tmp;
				num = i;
			}
		}
		System.out.println("maxLengthNum: " + num +", maxCycleLength: "+maxCycleLength);

		long endTime = System.currentTimeMillis();
		System.out.println("time used:�� " + (endTime - startTime) + "ms.");	

	}

}
