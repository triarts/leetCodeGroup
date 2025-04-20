package org.example.dynamicProgramming;

public class HouseRobber
{

	public static void main (String[] args)
	{
		System.out.println(new HouseRobber().rob(new int[]{2,7,9,3,1}));

		//dp[0] = 2
		//dp[1] = max(2, 7) = 7
		//dp[2] = max(7, 2+9) = 11
		//dp[3] = max(11, 7+3) = 11
		//dp[4] = max(11, 11+1) = 12
	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		if (n == 1) return nums[0];

		int prev1 = Math.max(nums[0], nums[1]);
		int prev2 = nums[0];

		for (int i = 2; i < n; i++) {
			int temp = Math.max(prev1, prev2 + nums[i]);
			prev2 = prev1;
			prev1 = temp;
		}

		return prev1;
	}

}