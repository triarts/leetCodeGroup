package org.example.greedy;

import java.util.*;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) return new int[0][0];

		// Step 1: Sort intervals by start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> result = new ArrayList<>();

		// Step 2: Merge intervals
		int[] currentInterval = intervals[0];
		result.add(currentInterval);

		for (int[] interval : intervals) {
			if (interval[0] <= currentInterval[1]) {
				// There is overlap, merge intervals by updating the end time
				currentInterval[1] = Math.max(currentInterval[1], interval[1]);
			} else {
				// No overlap, add a new interval
				currentInterval = interval;
				result.add(currentInterval);
			}
		}

		// Convert List to array and return
		return result.toArray(new int[result.size()][]);
	}

	// Test
	public static void main(String[] args) {
		MergeIntervals solution = new MergeIntervals();
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

		int[][] mergedIntervals = solution.merge(intervals);

		for (int[] interval : mergedIntervals) {
			System.out.println(Arrays.toString(interval)); // Output: [1, 6], [8, 10], [15, 18]
		}
	}
}