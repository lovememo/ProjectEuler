package net.lovememo.euler.Problem01_25;

public class Problem24 {

	public static int[] seq = new int[10];
	private static int no = 0;
	
	/*ȫ���е�ʱ���ù�������־λ1��û�ù�������־λ0*/
	public static int getMinNumber(int[] remainNumberCanBeUsed) {
		int minNumber = 10;
		for(int i=0; i<remainNumberCanBeUsed.length; i++) {
			if(remainNumberCanBeUsed[i]==0 && i<minNumber) {
				minNumber = i;
				remainNumberCanBeUsed[i] = -1;
			}
		}
		return minNumber;
	}
	
	public static void printSeq(int[] seq) {
		for(int i=0; i<seq.length; i++) {
			System.out.print(seq[seq.length-i-1]);
		}
		System.out.println();
	}
	
	public static void generateSeq(int[] seq, int number, int[] remainNumberCanBeUsed) {
		int minNumber;
		if(number == 0) {
			for(; (minNumber = getMinNumber(remainNumberCanBeUsed)) != 10;) {
				seq[number] = minNumber;
				no ++;
				if(no == 1000000)
					printSeq(seq);				
			}	
			return;
		}
		
		int[] nextRemainNumberCanBeUsed = new int[remainNumberCanBeUsed.length];
		for(int i=0; i<remainNumberCanBeUsed.length; i++) {
			nextRemainNumberCanBeUsed[i] = remainNumberCanBeUsed[i];
		}
		
		for(; (minNumber = getMinNumber(remainNumberCanBeUsed)) != 10;) {
			seq[number] = minNumber;
			nextRemainNumberCanBeUsed[minNumber] = -1;

			int[] nextRemainNumberCanBeUsed2 = new int[remainNumberCanBeUsed.length];
			for(int i=0; i<remainNumberCanBeUsed.length; i++) {
				nextRemainNumberCanBeUsed2[i] = nextRemainNumberCanBeUsed[i];
			}			
			generateSeq(seq,number-1,nextRemainNumberCanBeUsed2);			
			nextRemainNumberCanBeUsed[minNumber] = 0;
		}		
		
	}
	
	public static void generateSeq() {		
		int[] remainNumberCanBeUsed = new int[10];
		for(int i=0; i<10; i++)
			remainNumberCanBeUsed[i] = 0;
		
		generateSeq(seq, 9, remainNumberCanBeUsed);
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		generateSeq();
		long endTime = System.currentTimeMillis();
		System.out.println("����ʱ�䣺 " + (endTime - startTime) + "ms.");	
	}
}

/*
1.�ж��ڼ�λ
2.��ȡ��Ҫ�ж���ֵ������Щ��ѡ��ֵremain������һ�ݸ�����ѡ��ֵnextRemain
3.������ѡ��ֵ
	a.�ӿ�ѡ��ֵremain�л�ȡ��С��ֵ��minV��������֮��Ϊ����ѡ
	b.���ж���ֵ��ΪminV
	c.��nextRemain�н�minV��ֵ��Ϊ����ѡ
	d.�ж���һλ���ݹ����������Ҫ�ṩ��Ϣ����һλ��ţ����ж�������seq��ʣ���ѡ��ֵ��
	e.�ָ�nextRemain��minV��ֵΪ��ѡ��Ϊ��һ��ѭ��������׼����


*/