package org.example.binarySearch;

public class KokoEatingBananas
{

//🍌 Problem Summary:
//Koko loves to eat bananas. She has n piles of bananas, and the ith pile has piles[i] bananas. She eats at most k bananas per hour, but only from one pile per hour.
//Your goal is to determine the minimum integer speed k (bananas/hour) such that Koko can eat all the bananas within h hours.
//
//💡 Intuition: Binary Search on Answer
//We’re looking for the minimum speed k that lets Koko finish within h hours.
//
//Minimum possible k = 1
//
//Maximum possible k = max(piles) (if she eats a whole pile in an hour)
//
//We binary search between those bounds.

	public static void main(String[] args)
	{

//Input: piles = [3,6,7,11], h = 8
//Output: 4

//Time Complexity:
//O(n × log m)
//Where:
//
//n = piles.length
//
//m = max(piles)

		System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{3,6,7,11},8));
	}

	public int minEatingSpeed(int[] piles, int h)
	{
		int left = 1;
		int right = getMax(piles); // max pile size

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (canFinish(piles, h, mid)) {
				right = mid; // try a smaller k
			} else {
				left = mid + 1; // need faster k
			}
		}

		return left;
	}

	private boolean canFinish(int[] piles, int h, int k)
	{
		int hours = 0;
		for (int pile : piles) {
			hours += (pile + k - 1) / k; //same as (int)Math.ceil((double)pile / k);
		}
		return hours <= h;
	}

	private int getMax(int[] piles)
	{
		int max = 0;
		for (int pile : piles) {
			max = Math.max(max, pile);
		}
		return max;
	}
}