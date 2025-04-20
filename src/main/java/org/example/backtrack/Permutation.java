package org.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutation
{
	public static void main(String[] args)
	{
		new Permutation().permute(new int[]{1,2,3});
	}

	public void permute(int[] nums)
	{
		boolean[] used = new boolean[nums.length];
		List<List<Integer>> results = new ArrayList<>();
		rotate(nums, used, new ArrayList<>(), results);

		for(List<Integer> res : results)
		{
			System.out.println(res);
		}

		//[1, 2, 3]
		//[1, 3, 2]
		//[2, 1, 3]
		//[2, 3, 1]
		//[3, 1, 2]
		//[3, 2, 1]


	}

	public void rotate(
		int[] nums,
		boolean[] used,
		List<Integer> currPath,
		List<List<Integer>> results)
	{
		//stopping condition
		if(currPath.size() == nums.length)
		{
			results.add(new ArrayList<>(currPath));
			return;
		}

		for(int i=0;i<nums.length;i++)
		{
			//prevent repeating
			if(used[i] == true)
			{
				continue;
			}

			currPath.add(nums[i]);
			used[i] = true;

			rotate(nums, used, currPath, results);

			//reset condition
			currPath.remove(currPath.size()-1);
			used[i] = false;
		}
	}
}