package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations
{
//🔀 Combination:
//Order doesn't matter.
//
//It’s about selecting items.
//
//Example: Picking 3 fruits from {apple, banana, cherry} gives the same combo whether it's (apple, banana, cherry) or (cherry, apple, banana).
	public static void main(String[] args)
	{
		Combinations c = new Combinations();
		int[] nums = {1, 2, 3, 4};
		List<List<Integer>> combos = c.combine(nums, 2);
		System.out.println(combos);
	}

	public List<List<Integer>> combine(	int[] nums,
										int k)
	{
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, k, 0, new ArrayList<>(), result);
		return result;
	}

	private void backtrack(	int[] nums,
							int k,
							int start,
							List<Integer> path,
							List<List<Integer>> result)
	{
		if (path.size() == k)
		{
			result.add(new ArrayList<>(path));
			return;
		}

		for (int i = start; i < nums.length; i++)
		{
			path.add(nums[i]); 							// choose
			backtrack(nums, k, i + 1, path, result);	// explore
			path.remove(path.size() - 1);				// unchoose
		}
	}
}