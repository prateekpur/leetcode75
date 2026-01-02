package leetcode;

import java.util.*;

public class LongestSubstring {
	public static void main (String args[])	{
		lengthOfLongestSubstring("zxyzxyz");
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int pos = 0, len = s.length(), max = 0, prevMatch = 0;
    	Set<Character> chars = new HashSet();
    	while (pos < len)	{
    		char c = s.charAt(pos);
    		if (chars.contains(c))	{
    			//find matching pos and restart
    			pos = s.indexOf(c, prevMatch) + 1;
    			prevMatch = pos;
    			chars.clear();
    			continue;
    		}
    		chars.add(c);
    		max = Math.max(max, chars.size());
    		++pos;
    	}
    	return max;
    }


}
