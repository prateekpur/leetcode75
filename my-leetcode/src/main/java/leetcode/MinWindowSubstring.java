package leetcode;

import java.util.*;

public class MinWindowSubstring {
	public static void main (String args[])	{
		minWindow("OUZODYXAZV", "XYZ");
	}
	
    public static String minWindow(String s, String t) {
    	String sub = "";
    	Map<Character, Integer> freqMap = new HashMap();
    	for (char c: t.toCharArray())	{
    		if (freqMap.putIfAbsent(c, 1) != null)	{
    			freqMap.put(c, freqMap.get(c) + 1);
    		}
    	}
    	for (int i = 0; i < s.length(); ++i)	{
    		if (freqMap.containsKey(s.charAt(i)))	{
    			int j = checkSubstringExists(s, t, i, freqMap);
    			if (j == -1)	{
    				continue;
    			}
    			if (sub.equalsIgnoreCase(""))	{
    				sub = s.substring(i,  j+1);
    			}	else if (sub.length() > (j+1 -i))	{
    				sub = s.substring(i,  j+1);
    			}
    			//System.out.println(sub);
    		}
    	}
		//System.out.println("Result : " + sub);
        return  sub;
    }
    
    static int checkSubstringExists(String s, String t, int pos, Map<Character, Integer> freq)	{
    	Map<Character, Integer> freqClone = new HashMap();
    	freqClone.putAll(freq);
    	for (int i = pos; i < s.length(); ++i)	{
    		char c = s.charAt(i);
    		if (freqClone.containsKey(c))	{
    			if (freqClone.get(c) != 0)	{
        			freqClone.put(c, freqClone.get(c) - 1);
        			if (freqClone.values().stream().allMatch(v -> v == 0))	{
        				return i;
        			}
    			}
    		}
    	}
    	//check if all values in freqClone are 0
    	return -1;
    }
}
