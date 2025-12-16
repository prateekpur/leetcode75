package leetcode;

import java.util.*;

public class Sudoku {
	
	public static void main(String args[])	{
		/*char board[][] = {{'1','2','.','.','3','.','.','.','.'},
				{'4','.','.','5','.','.','.','.','.'},
				{'.','9','8','.','.','.','.','.','3'},
				{'5','.','.','.','6','.','.','.','4'},
				{'.','.','.','8','.','3','.','.','5'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','.','.','.','.','.','2','.','.'},
				{'.','.','.','4','1','9','.','.','8'},
				{'.','.','.','.','8','.','.','7','9'}};*/
		char board[][] = {{'1','2','.','.','3','.','.','.','.'},
				 {'4','.','.','5','.','.','.','.','.'},
				 {'.','9','1','.','.','.','.','.','3'},
				 {'5','.','.','.','6','.','.','.','4'},
				 {'.','.','.','8','.','3','.','.','5'},
				 {'7','.','.','.','2','.','.','.','6'},
				 {'.','.','.','.','.','.','2','.','.'},
				 {'.','.','.','4','1','9','.','.','8'},
				 {'.','.','.','.','8','.','.','7','9'}};
		isValidSudoku(board);
	}
	
    public static boolean isValidSudoku(char[][] board) {
    	Map<Integer, Set<Character>> rows = new HashMap(), cols = new HashMap(), squares = new HashMap();
    	//intialize maps
    	for (int i = 0; i < 9; ++i)	{
    		rows.put(i, new HashSet<Character>());
    		cols.put(i, new HashSet<Character>());
    		squares.put(i, new HashSet<Character>());
    	}
    	Set<Character> currentSet;
    	for (int i = 0; i < 9; ++i)	{
    		for (int j = 0; j < 9; j++)	{
    			if (board[i][j] == '.')	{
    				continue;
    			}
				currentSet = rows.get(i);
				if (currentSet.contains(board[i][j]))	{
    				return false;
    			}	else	{
    				currentSet.add(board[i][j]);
    				rows.put(i, currentSet);
    			}
				
				currentSet = cols.get(j);
    			if (currentSet.contains(board[i][j]))	{
    				return false;
    			}	else	{
    				currentSet.add(board[i][j]);
    				cols.put(j, currentSet);
    			}
    			
    			//find right square
    			int squareCnt = 0;
    			switch(i)	{
    				case 0:
    				case 1:
    				case 2:
    					if (j <= 2)	{
    						squareCnt = 0;
    					}	else if (j <= 5)	{
    						squareCnt = 1;
    					}	else	{
    						squareCnt = 2;
    					}
    					break;
    				case 3:
    				case 4:
    				case 5:
    					if (j <= 2)	{
    						squareCnt = 3;
    					}	else if (j <= 5)	{
    						squareCnt = 4;
    					}	else	{
    						squareCnt = 5;
    					}
    					break;
    				case 6:
    				case 7:
    				case 8:
    					if (j <= 2)	{
    						squareCnt = 6;
    					}	else if (j <= 5)	{
    						squareCnt = 7;
    					}	else	{
    						squareCnt = 8;
    					}
    					break;
    			}
    			currentSet = squares.get(squareCnt);
    			if (squares.get(squareCnt).contains(board[i][j]))	{
    				return false;
    			}	else	{
    				currentSet.add(board[i][j]);
    				squares.put(squareCnt, currentSet);
    			}
    		}
    	}
    	return true;
    }

}
