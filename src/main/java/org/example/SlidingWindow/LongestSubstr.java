package org.example.SlidingWindow;

import java.util.HashMap;

public class LongestSubstr
{

	public static void main(String[] args)
	{
		System.out.println(new LongestSubstr().lengthOfLongestSubstring("abcfabcc"));
	}

	//Longest Substring Without Repeating Characters
	public int lengthOfLongestSubstring(String s)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0, maxLen = 0;

		for (int right = 0; right < s.length(); right++)
		{
			char c = s.charAt(right);

			// If character is already in the map and its index is >= left pointer
			if (map.containsKey(c))
			{
				// Move left pointer to 1 position after the last seen duplicate
				left = Math.max(left,map.get(c));
			}

			// Update character's last seen index
			map.put(c, right+1);

			// Update max length
			maxLen = Math.max(maxLen, right - left + 1);
		}

		return maxLen;
	}
}