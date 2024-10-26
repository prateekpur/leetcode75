package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
//11:35
public class MaxKSumPairs {
	public static Logger logger = Logger.getLogger(MaxKSumPairs.class.getName());
	public static void main(String args[])	{
		logger.setLevel(Level.INFO);
		String l = Integer.toString(Integer.MAX_VALUE);
		logger.log(Level.INFO, " : " + l);
		Double d = Double.parseDouble(l) - Math.pow(10, 9);
		logger.log(Level.INFO, " : " + Math.pow(10, 9));
		maxOperations(new int[] {3,1,3,4,3}, 6);
	}
	
    public static int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        int numOps = 0;
        for (int i : nums)	{
        	if (map.containsKey(k - i))	{
        		int cnt = map.get(k-i);
        		if (cnt > 1)	{
        			map.put(k - i, --cnt);
        		}	else	{
        			map.remove(k-i);
        		}
        		++numOps;
        	} else	{
        		int cnt = map.getOrDefault(i, 0);
        		map.put(i, ++cnt);
        	}
        }
        return numOps;
    }

}