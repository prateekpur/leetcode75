package leetcode;

import java.util.*;

public class GroupAnagrams {
	
	public static void main(String args[])	{
		System.out.print((int)'a');
		//System.out.print((int)'z');
		List<Integer> freq = getFrequency("eat");
		
		String words[] = {"eat","tea","tan","ate","nat","bat"};
		//String words[] = {""};
		List<List<String>> res = makeGroups(words);
		//["eat","tea","tan","ate","nat","bat"]


	}
	
	static List<List<String>> makeGroups(String words[])	{
		Map<List<Integer>, List<String>> groups = new HashMap();
		//List<Integer> freq = new ArrayList();
		for (String word : words)	{
			List<Integer> freq = getFrequency(word);
			List<String> group = new ArrayList();
			if (groups.containsKey(freq))	{
				group = groups.get(freq);
			}
			group.add(word);
			groups.put(freq, group);
		}
		List<List<String>> result = new ArrayList();
		for (List<String> li : groups.values())	{
			result.add(li);
		}
		return result;
	}
	
	static List<Integer> getFrequency(String s)	{
		int n = 26;
		ArrayList<Integer> freq = new ArrayList<>(Collections.nCopies(n, 0));
		char ch[] = s.toCharArray();
		for (char c: ch)	{
			int i = freq.get(c - 97);
			freq.set(c - 97, ++i);
		}
		return freq;
	}

}
