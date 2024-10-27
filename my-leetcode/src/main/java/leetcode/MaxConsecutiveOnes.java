package leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaxConsecutiveOnes {
	public static Logger logger = Logger.getLogger(MaxConsecutiveOnes.class.getName());
	public static void main(String args[]) throws IOException	{
		logger.log(Level.INFO, ""+ longestOnes1(new int[]{1,0,0,0}, 2));
	}
	
    public static int longestOnes1(int[] nums, int k) {
    	if(nums.length == k)	{
    		return k;
    	}
    	//liZeros is sorted because elements are inserted in correct order
    	List<Integer> liZeros = new ArrayList();
    	for (int i=0; i < nums.length; ++i)	{
    		if (nums[i] == 0)	{
    			liZeros.add(i);
    		}
    	}
    	if(liZeros.size() <= k)	{
    		return nums.length;
    	}
    	logger.setLevel(Level.INFO);
    	//logger.log(Level.INFO, ""+ liZeros);
    	int start = 0, end = 0, maxLength = 0;
    	while (end <= liZeros.size()-1)	{
    		logger.log(Level.INFO, " : "+ liZeros.get(start) + " : " + liZeros.get(end));
    		if (end - start == k)	{
		    	int length = 0;
		    	if(start == 0)	{
		    		length = liZeros.get(end);
		    	}	else	{
		    		if (end == liZeros.size()-1)	{
		    			length = nums.length - liZeros.get(start-1)-1;
		    		}
		    		length = liZeros.get(end) - liZeros.get(start-1)-1;
		    	}
		    	logger.log(Level.INFO, " : "+ liZeros.get(start) + " : " + liZeros.get(end) + " : " + length);
		    	maxLength = Integer.max(maxLength, length);
				start++;
	    	}
    		end ++;
    	}
    	//scenario of last number being 1
    	if(nums[nums.length-1] == 1)	{
    		int last = liZeros.get(liZeros.size()-k-1);
    		int lastLength = nums.length - last-1;
    		maxLength = Integer.max(maxLength, nums.length - last);
    		logger.log(Level.INFO, ""+ maxLength);
    	}
    	//cover scenario of last number being 0    	
    	if (nums[nums.length-1] == 0)	{
    		int length = 0;
    		if (liZeros.size() <= k)	{
    			length = nums.length;
    		}	else	{
    			length = liZeros.get(liZeros.size()-1) - liZeros.get(liZeros.size()-1-k);
    		}
	    	maxLength = Integer.max(maxLength, length);
    	}
    	
    	return maxLength;
    }
    
    public static int longestOnes(int[] nums, int k) {
    	if(nums.length == k)	{
    		return k;
    	}
    	//liZeros is sorted because elements are inserted in correct order
    	List<Integer> liZeros = new ArrayList();
    	for (int i=0; i < nums.length; ++i)	{
    		if (nums[i] == 0)	{
    			liZeros.add(i);
    		}
    	}
    	if(liZeros.size() == k)	{
    		return nums.length;
    	}
    	logger.setLevel(Level.INFO);
    	//logger.log(Level.INFO, ""+ liZeros);
    	int start = 0, end = 0, maxLength = 0;
    	while (end < liZeros.size()-1)	{
    		end ++;
	    	if (end - start == k+1)	{
		    	int length = 0;
		    	if(start == 0)	{
		    		length = liZeros.get(end)-1;
		    	}	else	{
		    		if (end == liZeros.size()-1)	{
		    			length = nums.length - liZeros.get(start)-1;
		    		}
		    		length = liZeros.get(end) - liZeros.get(start)-1;
		    	}
		    	logger.log(Level.INFO, " : "+ liZeros.get(start) + " : " + liZeros.get(end) + " : " + length);
		    	maxLength = Integer.max(maxLength, length);
				start++;
	    	}
    	}
    	//cover scenario of last number being 0
    	//logger.log(Level.INFO, " : "+ liZeros.get(liZeros.size()-1) + " : " + nums.length);
    	
    	if (liZeros.get(liZeros.size()-1) == nums.length-1)	{
    		int length = 0;
    		if (liZeros.size() <= 2)	{
    			length = nums.length;
    		}	else	{
    			length = liZeros.get(liZeros.size()-1) - liZeros.get(liZeros.size()-1-k);
    		}
	    	maxLength = Integer.max(maxLength, length);
    	}
    	
    	return maxLength;
    }
    
    public static int countOnes(int nums[], int start, int end, int k)	{
    	//find 0 before start
    	
    	return -1;
    }
}
