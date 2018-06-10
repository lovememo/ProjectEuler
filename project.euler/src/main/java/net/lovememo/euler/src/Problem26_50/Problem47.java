package Problem26_50;

import java.util.ArrayList;

import util.lovememo.net.EulerUtil;

public class Problem47 {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		long s = EulerUtil.start();
		long counts = 4;
		for(int i=210; i<=100000000; i++) {
			ArrayList<Long> list = EulerUtil.getPrimeFactor(i);
			if(list.size() != counts)
				continue;
			boolean flag = true;
			for(int j=i+1; j<i+counts; j++) {
				list = EulerUtil.getPrimeFactor(j);
				if(list.size() != counts) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(i);
				break;
			}
		}
		
		EulerUtil.end(s);
		ArrayList<Long> list2 = EulerUtil.getPrimeFactor(134043);
		for(int k=0; k<list2.size(); k++) {
			System.out.println(list2.get(k));
		}
	}

}
