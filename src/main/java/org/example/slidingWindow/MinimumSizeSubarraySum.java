package org.example.slidingWindow;

public class MinimumSizeSubarraySum
{
	//Minimum Size Subarray Sum Leetcode #209
	public static void main(String[] args)
	{
		System.out.println(
			new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2,3,1,2,4,3})
		);


		//Input: target = 7, nums = [2,3,1,2,4,3]
		//Output: 2
		//Explanation: The subarray [4,3] has the minimal length of 2.

	}

	public int minSubArrayLen(int target, int[] nums)
	{
		int n = nums.length;
		int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

		for (int right = 0; right < n; right++)
		{
			sum += nums[right];

			// Shrink the window while the sum is >= target
			while (sum >= target)
			{
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

}