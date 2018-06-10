package net.lovememo.euler.Problem01_25;

public class Problem19 {
	
	public static boolean isLeapYear(int year) {
		if(year%100==0 && year%400!=0){
			return false;
		}
		else if(year%100==0 && year%400==0) {
			return true;
		}
		else if(year%4 == 0) {
			return true;
		}
		return false;
	}
	
	public static int getSundayCount(int endYear) {
		int currentDays = 0;		
		int month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int sundaySum = 0;
		for(int currentYear=1900; currentYear<endYear; currentYear++) {
			if(isLeapYear(currentYear))
				month[1] = 29;
			else
				month[1] = 28;
			for(int currentMonth=0; currentMonth<12; currentMonth++) {
				currentDays ++;
				if(currentDays%7 == 0) {
					//System.out.println(currentYear + "��" +(currentMonth+1) + "��1��");
					sundaySum++;
				}
				currentDays += month[currentMonth] - 1;
			}
		}
		return sundaySum;
	}
	
	public static void main(String[] args) {
		System.out.println(getSundayCount(2001) - getSundayCount(1901));
		
	}

}
