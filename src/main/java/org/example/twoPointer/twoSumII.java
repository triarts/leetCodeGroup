package org.example.twoPointer;

import java.util.Arrays;

public class twoSumII
{
	public static void main(String[] args)
	{
		// Leetcode 167: Two Sum II - Input Array Is Sorted.
		//🔍 Problem Summary:
		//You're given a 1-indexed array numbers (sorted in non-decreasing order) and a target.
		// Return the 1-based indices of the two numbers such that they add up to the target.
		//
		//💡 Constraints:
		//Exactly one solution exists.
		//
		//You must use only constant extra space.

		//Input: numbers = [2,7,11,15], target = 9
		//Output: [1,2] // because 2 + 7 = 9
		System.out.println(
			Arrays.toString(new twoSumII().twoSum(new int[]{2,7,11,15},9))
		);
	}

	public int[] twoSum(int[] numbers, int target)
	{
		int left = 0, right = numbers.length - 1;

		while (left < right)
		{
			int sum = numbers[left] + numbers[right];

			if (sum == target)
			{
				return new int[] {left + 1, right + 1}; // 1-indexed
			}
			else if (sum < target)
			{
				left++; // Need a larger sum
			}
			else
			{
				right--; // Need a smaller sum
			}
		}

		return new int[] {}; // Will never hit this due to problem guarantees
	}
}