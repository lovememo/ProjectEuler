package net.lovememo.euler.Problem01_25;

public class Problem5 {
	//�ֽ����� ���� 6 �ֽ�Ϊ 2 ��3 ��cache�������� [0,0,1,1,0,0,0,0...]
	private static long getPrimeFactor(long num, int[]cache) {
		for(long i=2; i<num; i++) {
			if(num%i == 0) {
				cache[(int)i] ++;
				return getPrimeFactor(num/i,cache);
			}
		}
		cache[(int)num] ++;
		return num;
	}
	
	/*��1-20����С������*/
	public static void main(String[] args) {
		int num = 20;
		int sum = 1;
		int[] globalTable = new int[num+1];
		for(int i=1; i<=num; i++) {
			int[] cache = new int[num+1];
			//��ǰ������������ȫ����������Ƚϣ�ֵѡ��ģ�ԭ���ҹ�������
			getPrimeFactor(i,cache);
			for(int j=1; j<=num; j++) {
				if(cache[j] > globalTable[j])
					globalTable[j] = cache[j];
			}
		}		
		for(int i=1; i<=num; i++) {
			for(int j=0;j<globalTable[i];j++) {
				sum *= i;
			}
		}
		System.out.println(sum);		
	}
}
