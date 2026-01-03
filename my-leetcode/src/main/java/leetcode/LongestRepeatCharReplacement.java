package leetcode;

import java.util.*;

public class LongestRepeatCharReplacement {
	public static void main(String args[])	{
		characterReplacement("AAABABB", 1);
	}
	
    public static int characterReplacement(String s, int k) {
    	int max = 0;
    	Map<Character, Integer> count = new HashMap();
    	int start = 0, curr = 0;
    	while (curr < s.length())	{
    		char c = s.charAt(curr);
    		if(count.putIfAbsent(c, 1) != null)	{
    			count.put(c,  count.get(c) + 1);
    		}
    		if (findDifference(count) > k)	{
    			char c1 = s.charAt(start);
    			int cnt = count.get(c1);
    			count.put(c1, cnt - 1);
    			++start;
    		}
    		++curr;
    		int sum = count.values().stream().mapToInt(Integer::intValue).sum();
    		max = Math.max(max, sum);
    	}
    	return max;
    }
    
    static int findDifference(Map<Character, Integer> count)	{
    	//find highest number in count map, difference is sum of all other numbers
    	int max = Integer.MIN_VALUE, sum = 0;
    	for (int i : count.values())	{
    		sum += i;
    		if (i > max)	{
    			max = i;
    		}
    	}
    	return sum - max;
    }
}
