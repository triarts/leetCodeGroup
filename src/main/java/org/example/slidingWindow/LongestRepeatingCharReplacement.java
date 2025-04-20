package org.example.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement
{
	public static void main(String[] args)
	{
		System.out.println(new LongestRepeatingCharReplacement().characterReplacement("AABABBA",1));

		//Input: s = "AABABBA", k = 1
		//Output: 4
		//Explanation: Replace one 'A' with 'B' → "AABBBBA" or similar → longest is 4.
	}

	public int characterReplacement(String s, int k)
	{
		Map<Character,Integer> freqByChar = new HashMap<>();
		int left = 0, maxCount = 0, maxLen = 0;

		for (int right = 0; right < s.length(); right++)
		{
			char c = s.charAt(right);

			freqByChar.put(	c,
							freqByChar.getOrDefault(c,0) + 1);

			// Track the count of the most frequent char in the current window
			maxCount = Math.max(maxCount, freqByChar.get(c));

			// If we need to replace more than k characters, shrink the window
			while ((right - left + 1) - maxCount > k)
			{
				char curr = s.charAt(left);
				freqByChar.put(curr,freqByChar.get(curr)-1);
				left++;
			}

			// Update max length of valid window
			maxLen = Math.max(maxLen, right - left + 1);
		}

		return maxLen;
	}
}