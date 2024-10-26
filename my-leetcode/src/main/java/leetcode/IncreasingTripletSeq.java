package leetcode;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.roaringbitmap.RoaringBitmap;


import com.zaxxer.sparsebits.SparseBitSet;

public class IncreasingTripletSeq {
	public static Logger logger = Logger.getLogger(IncreasingTripletSeq.class.getName());
	public static void main(String args[])	{
    	logger.setLevel(Level.INFO);
    	//logger.log(Level.INFO, "" + Integer.MAX_VALUE);
    	logger.log(Level.INFO, Boolean.toString(increasingTriplet1(new int[] {2, 1, 5, 0, 4, 6})));
	}
	
	public static void sorted(int nums[])	{
		TreeSet<Integer> sortedSet = new TreeSet<Integer>();
		for (int i : nums)	{
			sortedSet.add(i);
		}
	}
	
    public static boolean increasingTriplet(int[] nums) {
    	//logger.setLevel(Level.INFO);
    	TreeSet<Integer> sortedSet = new TreeSet<Integer>();
    	Set<Integer> match = new HashSet<Integer>();
    	RoaringBitmap lessNums = new RoaringBitmap();
    	sortedSet.add(nums[0]);
    	for (int i : nums)	{
			SortedSet<Integer> lessElements = sortedSet.headSet(i);
			if(!lessElements.isEmpty())	{
    			lessNums.add(i);
				//match.add(i);
			}
			for (int j : lessElements)	{
				//lessNums.
				if (lessNums.contains(j))	{
					//logger.log(Level.INFO, "Nums which are set : " + i + " : " + j);
					return true;
				}
				/*if(match.contains(j))	{
					return true;
				}*/
			}
			sortedSet.add(i);
    	}
    	return false;
    }
    
    public static boolean increasingTriplet1(int[] nums) {
    	int first = Integer.MAX_VALUE, sec = Integer.MAX_VALUE;
    	for (int i : nums)	{
    		if (i <= first)	{
    			first = i;
    		} else if (i <= sec)	{
    			sec = i;
    		}	else	{
    			return true;
    		}
    	}
    	return false;
    }

}


//2147483647
//2147483647