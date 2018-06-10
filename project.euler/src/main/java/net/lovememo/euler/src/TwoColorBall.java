import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// RED 01 TO 33
// BLUE 01 TO 16
public class TwoColorBall {
	
	/**
	 * ¾ùÔÈ·Ö²¼
	 * @throws InterruptedException
	 */
	public static void get01UniformNum() throws InterruptedException {		
		
		int range = 33;
		int[] results = new int[range];
//		1988
//		1954
//		2016
//		2033
//		2010
		
		for(int i=0; i<=10000; i++)
		{	
			Random seed = new Random(System.currentTimeMillis() );
			Thread.sleep(1);
			for(int j=0; j<18; j++)
				seed.nextLong();
			Random rnd = new Random(seed.nextLong() );
			int num = (int)(rnd.nextInt(range));
			results[num] ++;
			
		}
		for(int i=0; i<results.length; i++) {
			System.out.println(""+(i+1)+"  "+results[i]);
		}
		
	}
	
	public static void getSixRedBallNumers() throws InterruptedException {
		System.out.print("ºìÇò£º ");
		List<String> numList = new ArrayList<String>();
		
		while(numList.size() != 6) {
			Random seed = new Random(System.currentTimeMillis());
			
			for(int j=0; j<18; j++) {
				seed.nextLong();
				Thread.sleep(1);
			}
			
			Random rnd = new Random(seed.nextLong());			
			Thread.sleep(500);			
			int num = rnd.nextInt(33) + 1;
			String number;
			if(num <= 9)
				number = "0" + num;
			else
				number = num + "";
			
			if(!numList.contains(number)) {
				numList.add(number);
				
				System.err.print(number + " ");
			}
		}
		System.out.println();
	}
	
	public static void getBlueBallNumer() throws InterruptedException {
		System.out.print("À¶Çò£º ");
		Random seed = new Random(System.currentTimeMillis());
		
		for(int j=0; j<18; j++) {
			seed.nextLong();
			Thread.sleep(1);
		}
		
		Random rnd = new Random(seed.nextLong());			
		Thread.sleep(500);			
		int num = rnd.nextInt(16) + 1;
		String number;
		if(num <= 9)
			number = "0" + num;
		else
			number = num + "";
		
		System.out.println(number);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		TwoColorBall.getSixRedBallNumers();
		TwoColorBall.getBlueBallNumer();
		
		
		
		

		
	}
}
