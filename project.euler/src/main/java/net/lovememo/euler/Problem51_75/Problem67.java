package net.lovememo.euler.Problem51_75;

import net.lovememo.euler.Problem01_25.Problem18;
import net.lovememo.euler.util.EulerUtil;

public class Problem67 {
	
	//triangle number
	
	//��Ҷ�ӽڵ����֣����ϼ�Ҷ�ӣ�ֱ�����ڵ�
	public static int getMaxPathSum(int[][] nums) {
		int height = nums.length;
		for(int i=height-1; i>=1; i--) {
			int[] levelLeafNodes = nums[i];//��ǰ���ϵ�����Ҷ�ӽڵ�
			int[] priorLevelLeafNodes = nums[i-1];//�ϲ�����Ҷ�ӽڵ�
			for(int j=0; j<levelLeafNodes.length-1; j++) {
				int leftLeafNodeVal = levelLeafNodes[j];
				int rightLeafNodeVal = levelLeafNodes[j+1];
				int maxLeafVal = leftLeafNodeVal > rightLeafNodeVal ? leftLeafNodeVal : rightLeafNodeVal;
				priorLevelLeafNodes[j] += maxLeafVal;
			}
		}
		return nums[0][0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EulerUtil.start();
		System.out.println(getMaxPathSum(Problem18.number2));
		EulerUtil.end();
	}

}
