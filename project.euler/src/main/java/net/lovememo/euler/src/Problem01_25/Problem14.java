package Problem01_25;

public class Problem14 {
	public static long getCollatzSeqLength(long number) {
		long length = 1;
		if(number ==1)
			return length;
		
		if(number%2 == 0)
			number /= 2;
		else
			number = number * 3 + 1;
		
		return getCollatzSeqLength(number)+1;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long number=1L,maxNumber=0,maxLength=0L;
		
		while(number<1000000L) {
			long tmpNum = getCollatzSeqLength(number);
			if(tmpNum>maxLength) {
				maxLength = tmpNum;
				maxNumber = number;
			}
			number ++;
		}
		
		
		long endTime = System.currentTimeMillis();
		System.out.println(maxNumber+ " " + maxLength);
		System.out.println("ºÄÊ±£º" + (endTime - startTime) + "ms");
	}

}
// 3 10 5 16 8 4 2 1
//4 2 1