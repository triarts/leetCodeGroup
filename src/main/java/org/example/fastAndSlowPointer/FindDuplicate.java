package org.example.fastAndSlowPointer;

public class FindDuplicate
{
	public int findDuplicate(int[] nums)
	{
		// Step 1: Detect cycle using Floyd's Tortoise and Hare
		int slow = nums[0];
		int fast = nums[0];

		// Phase 1: Finding the intersection point in the cycle
		do
		{
			slow = nums[slow]; // Move slow by 1 step
			fast = nums[nums[fast]]; // Move fast by 2 steps
			System.out.println("-"+slow+" "+fast);
		} while (slow != fast);

		// Phase 2: Find the entrance to the cycle
		slow = nums[0];
		while (slow != fast)
		{
			slow = nums[slow]; // Move slow by 1 step
			fast = nums[fast]; // Move fast by 1 step
			System.out.println("--"+slow+" "+fast);
		}

		return slow; // The duplicate number
	}

	// Test
	public static void main(String[] args) {
		FindDuplicate solution = new FindDuplicate();
		int[] nums = {1, 3, 4, 2, 2};

		System.out.println(solution.findDuplicate(nums)); // Output: 2
	}
}