package Problem01_25;

public class Problem5 {
	//分解因数 比如 6 分解为 2 和3 这cache长这样： [0,0,1,1,0,0,0,0...]
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
	
	/*求1-20的最小公倍数*/
	public static void main(String[] args) {
		int num = 20;
		int sum = 1;
		int[] globalTable = new int[num+1];
		for(int i=1; i<=num; i++) {
			int[] cache = new int[num+1];
			//当前数的质因数和全局质因数表比较，值选大的（原因：找公倍数）
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
