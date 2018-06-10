package Problem26_50;

import java.util.HashMap;

public class Problem29 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		
		int num = 100;
		int[] prime = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
		
		int[][] basicInfo = new int[num+1][prime.length];//2到100的分解式 比如100 = 2^2 + 5^2 则basic[100][0] = 2; basic[100][2]=2;basic[100]其他值为0
		int[][][] numChess = new int[num+1][num+1][prime.length];//将a^b都分解为素因子指数次方的和
		for(int i=2; i<=num; i++) {
			int tmpNum = i;
			for(int j=0; j<prime.length; j++) {
				while(tmpNum%prime[j]==0 && tmpNum!=1) {
					basicInfo[i][j] ++;   //设basicInfo按列放置数据
					tmpNum /= prime[j];
				}
			}
		}
		
		for(int i=2; i<=num; i++) {
			for(int j=2; j<=num; j++) {
				for(int k=0; k<prime.length; k++) {
					numChess[j][i][k] = j * basicInfo[i][k];//
				}	
			}
		}
		
		HashMap<String,Integer> table = new HashMap<String,Integer>();//求解numChess[i][j]彼此不同的数的个数和
		for(int i=2; i<=num; i++) {
			for(int j=2; j<=num; j++) {
				String key = "";
				for(int k=0; k<prime.length; k++) {
					int value = numChess[i][j][k];
					if(value<10) {
						key = key + "00" + value;
					}
					else if(value>=10 && value<100)
						key = key + "0" + value;
					else if(value>=100 && value<1000)
						key = key + value;
					
				}
				if(table.get(key)==null) {
					table.put(key, 1);
				}
			}
		}
		System.out.println(table.size());
		long endTime = System.currentTimeMillis();
		System.out.println("耗时：" + (endTime - startTime) + "ms");
	}
}
