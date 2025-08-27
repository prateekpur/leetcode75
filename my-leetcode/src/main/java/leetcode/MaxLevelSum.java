package leetcode;

import java.util.*;

public class MaxLevelSum {
	
	public static void main (String args[])	{
		MaxLevelSum sum = new MaxLevelSum();
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.right = new TreeNode(3);*/
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(-8);*/
		TreeNode root = new TreeNode(989);
		root.right = new TreeNode(10250);
		root.right.left = new TreeNode(98693);
		root.right.right = new TreeNode(-89388);
		root.right.right.right = new TreeNode(-32127);
		int level = sum.maxLevelSum(root);
		System.out.println(Integer.MAX_VALUE);
		System.out.println("Level : " + level);
	}
	
    public int maxLevelSum(TreeNode root) {
    	List<TreeNode> thisLevel = new ArrayList<>(), nextLevel = new ArrayList<>();
    	int maxVal = Integer.MIN_VALUE, level = 0, maxLevel = 0;
    	thisLevel.add(root);
    	while(!thisLevel.isEmpty())	{
    		++level;
    		//List<Integer> li = new ArrayList();
    		int sum = 0;
    		for (TreeNode node : thisLevel)	{
    			//li.add(node.val);
    			sum += node.val;
    			if (node.right != null)	{
    				nextLevel.add(node.right);
    			}
    			if (node.left != null)	{
    				nextLevel.add(node.left);
    			}
    		}
			thisLevel.clear();
			thisLevel.addAll(nextLevel);
			nextLevel.clear();
			//System.out.println(li + " : " + level + " : " + maxVal);
			//int sum = li.stream().mapToInt(i -> i).sum();
			if (sum > maxVal)	{
				maxVal = sum;
				maxLevel = level;
			}
    	}
        return maxLevel;
    }
    
}
