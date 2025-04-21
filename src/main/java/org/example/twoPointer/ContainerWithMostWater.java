package org.example.twoPointer;

public class ContainerWithMostWater
{

	//Leetcode #11 – Container With Most Water — a very common and loved two-pointer problem.
	//
	//🔍 Problem Summary:
	//You're given an array height[] where each element represents the height of a vertical line on the x-axis.
	//Find two lines that together with the x-axis form a container, such that the container holds the most water.
	//
	//❗ Constraints:
	//Cannot tilt the container.
	//
	//Return the maximum area that can be contained.
	public static void main(String[] args)
	{
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}

	public int maxArea(int[] height)
	{
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right)
		{
			int h = Math.min(height[left], height[right]);
			int w = right - left;
			int currentArea = h * w;
			maxArea = Math.max(maxArea, currentArea);

			// Move the pointer at the shorter line
			if (height[left] < height[right])
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		return maxArea;
	}
}