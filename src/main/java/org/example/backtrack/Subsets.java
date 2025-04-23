package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums)
	{
		List<List<Integer>> result = new ArrayList<>();
		backtrack(0, nums, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(	int index,
							int[] nums,
							List<Integer> path,
							List<List<Integer>> result)
	{
		result.add(new ArrayList<>(path)); // Add current subset

		for (int i = index; i < nums.length; i++)
		{
			path.add(nums[i]);                      // choose
			backtrack(i + 1, nums, path, result);   // explore
			path.remove(path.size() - 1);           // unchoose
		}
	}

	public static void main(String[] args)
	{
		Subsets s = new Subsets();
		int[] nums = {1, 2, 3};
		List<List<Integer>> allSubsets = s.subsets(nums);
		System.out.println(allSubsets);
	}
}