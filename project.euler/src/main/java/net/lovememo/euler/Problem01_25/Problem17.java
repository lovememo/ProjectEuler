package net.lovememo.euler.Problem01_25;

public class Problem17 {

/*	
one  two  three  four  five  six  seven  eight  nine    
eleven  twelve  thirteen  fourteen  fifteen  sixteen  seventeen  eighteen  nineteen  
ten twenty  thirty  forty  fifty    sixty  seventy  eighty  ninety    
hundred
thousand
	*/
	public static int[] table;
	public static final int hundred  = 7;
	public static final int thousand = 8;
	public static final int and      = 3;
	
	public static int getLow(int number) {
		return number - getHigh(number) - getMiddle(number);
	}
	
	public static int getMiddle(int number) {
		return number/10*10 - getHigh(number);
	}
	
	public static int getHigh(int number) {
		return number/100*100;
	}
	
	public static void initTable() {
		table = new int[1000];
		table[1]  = 3;		table[11]  = 6;		table[10]  = 3;
		table[2]  = 3;		table[12]  = 6;		table[20]  = 6;
		table[3]  = 5;		table[13]  = 8;		table[30]  = 6;
		table[4]  = 4;		table[14]  = 8;		table[40]  = 5;
		table[5]  = 4;		table[15]  = 7;		table[50]  = 5;
		table[6]  = 3;		table[16]  = 7;		table[60]  = 5;
		table[7]  = 5;		table[17]  = 9;		table[70]  = 7;
		table[8]  = 5;		table[18]  = 8;		table[80]  = 6;
		table[9]  = 4;		table[19]  = 8;		table[90]  = 6;
		
		for(int i=21; i<100; i++) {
			int low  = table[i - i/10*10];
			int high = table[i/10*10];
			table[i] = high + low;
		}
		
		for(int i=100; i<1000; i++) {
			int high;
			if(table[getHigh(i)] == 0) 
				high = table[getHigh(i)/100] + hundred;
			else
				high = table[getHigh(i)];
				
			int low;
			if(getMiddle(i)==0 && getLow(i) ==0)
				low = 0;
			else
				low= and + table[getMiddle(i) + getLow(i)];
			table[i] = high + low;
		}
		
		table[0] = table[1] + thousand;
	}
	
	public static void main(String[] args) {
		initTable();
		int sum = 0;
		for(int i=0; i<1000; i++)
			sum += table[i];
		System.out.println(sum);
	}
}
