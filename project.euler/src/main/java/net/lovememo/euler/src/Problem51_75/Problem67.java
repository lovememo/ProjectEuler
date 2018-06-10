package Problem51_75;

import Problem01_25.Problem18;

public class Problem67 {
	
	//triangle number
	
	//从叶子节点入手，不断剪叶子，直到根节点
	public static int getMaxPathSum(int[][] nums) {
		int height = nums.length;
		for(int i=height-1; i>=1; i--) {
			int[] levelLeafNodes = nums[i];//当前层上的所有叶子节点
			int[] priorLevelLeafNodes = nums[i-1];//上层所有叶子节点
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
		util.lovememo.net.EulerUtil.start();
		System.out.println(getMaxPathSum(Problem18.number2));
		util.lovememo.net.EulerUtil.end();
	}

}
