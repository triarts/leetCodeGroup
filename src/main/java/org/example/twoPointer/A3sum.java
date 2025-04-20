package org.example.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3sum
{
	//🔍 Problem Summary:
	//Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]] such that:
	//
	//i != j != k
	//
	//nums[i] + nums[j] + nums[k] == 0
	//
	//Note: The solution set must not contain duplicate triplets.
	//
	//🧠 Intuition: Sort + Two Pointers
	//Step 1: Sort the array.
	//
	//Step 2: Loop through each element i, and for each i, use two pointers (left, right) to find pairs that sum with nums[i] to zero.
	//
	//Step 3: Skip duplicates to avoid repeated triplets.
	public static void main(String[] args)
	{
		//Input: nums = [-1, 0, 1, 2, -1, -4]
		//Output: [[-1, -1, 2], [-1, 0, 1]]
		System.out.println(new A3sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}


	public List<List<Integer>> threeSum(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums); // Step 1: sort

		for (int i = 0; i < nums.length - 2; i++)
		{
			// Skip duplicate values for i
			if (i > 0 && nums[i] == nums[i - 1]) continue;

			int left = i + 1, right = nums.length - 1;
			int target = -nums[i]; // nums[i] + nums[left] + nums[right] == 0

			while (left < right)
			{
				int sum = nums[left] + nums[right];

				if (sum == target)
				{
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));

					// Skip duplicates for left and right
					while (left < right && nums[left] == nums[left + 1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;

					left++;
					right--;
				}
				else if (sum < target)
				{
					left++;
				}
				else
				{
					right--;
				}
			}
		}

		return result;
	}

}