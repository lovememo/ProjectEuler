package Problem01_25;

public class Problem24 {

	public static int[] seq = new int[10];
	private static int no = 0;
	
	/*全排列的时候用过的数标志位1，没用过的数标志位0*/
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
		System.out.println("消耗时间： " + (endTime - startTime) + "ms.");	
	}
}

/*
1.判定第几位
2.获取需要判定的值还有哪些可选的值remain，复制一份副本可选的值nextRemain
3.遍历可选的值
	a.从可选的值remain中获取最小的值（minV），并将之置为不可选
	b.将判定的值置为minV
	c.在nextRemain中将minV的值置为不可选
	d.判定下一位（递归调用自身，需要提供信息：下一位序号，已判定的内容seq，剩余可选的值）
	e.恢复nextRemain中minV的值为可选（为下一轮循环遍历做准备）


*/