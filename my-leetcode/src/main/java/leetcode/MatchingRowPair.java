package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatchingRowPair {
	public static Logger logger = Logger.getLogger(MatchingRowPair.class.getName());
	
	public static void main(String args[])	{
    	logger.setLevel(Level.INFO);
    	int grid[][] = new int[][] {{3,2,1},{1,7,6},{2,7,7}};
		logger.log(Level.INFO, ":" + equalPairs(grid));
		grid = new int[][] {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
		logger.log(Level.INFO, ":" + equalPairs(grid));
	}
    public static int equalPairs(int[][] grid) {
    	int totalMatch = 0;
    	Map<String, Integer> mapRows = new HashMap();
    	logger.log(Level.INFO, ": Rows :");
    	for (int rows[] : grid)	{
    		StringBuilder bld = new StringBuilder("");
    		for (int i : rows)	{
    			bld.append(i);
    			bld.append(",");
    		}
    		logger.log(Level.INFO, ":" + bld.toString());
    		int cnt = mapRows.getOrDefault(bld.toString(), 0);
    		mapRows.put(bld.toString(), ++cnt);
    	}
    	logger.log(Level.INFO, ": Coloms :");
    	int numCols = grid[0].length, numRows = numCols;
    	for (int col = 0; col <numCols; ++col)	{
    		StringBuilder bld = new StringBuilder("");
    		for (int row = 0; row < numRows; ++row)	{
    			bld.append(grid[row][col]);
    			bld.append(",");
    		}
    		logger.log(Level.INFO, bld.toString());
    		totalMatch += mapRows.getOrDefault(bld.toString(), 0);
    		logger.log(Level.INFO, ":" + mapRows.getOrDefault(bld.toString(), 0));
    	}
    	
    	return totalMatch;
    }

}
