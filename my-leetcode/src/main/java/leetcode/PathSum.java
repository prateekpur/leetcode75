package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PathSum {
	static int cnt = 0;
	public static Logger logger = Logger.getLogger(PathSum.class.getName());
	public static void main(String args[])	{
		/*TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);
		logger.log(Level.INFO, Integer.toString(pathSum(root, 8)));*/
		//new test
		/*root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(-1);
		root.right.left = new TreeNode(-2);
		logger.log(Level.INFO, Integer.toString(pathSum(root, 3)));*/
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(-1);
		root.right.left = new TreeNode(-2);
		logger.log(Level.INFO, Integer.toString(pathSum(root, -1)));*/
		TreeNode root = new TreeNode(1000000000);
		root.left = new TreeNode(1000000000);
		root.left.left = new TreeNode(294967296);
		root.left.left.left = new TreeNode(1000000000);
		root.left.left.left.left = new TreeNode(1000000000);
		root.left.left.left.left.left = new TreeNode(1000000000);
		logger.log(Level.INFO, Integer.toString(pathSum(root, 0)));
	}
	
	public static int pathSum(TreeNode root, int targetSum) {
//		if (root == null)	{
//			return 0;
//		}
//		path1(root, "", 0, -1);
//		pathSum(root.left, 0);
//		pathSum(root.right, 0);		
//		return cnt;
		return pathSum1(root, targetSum, true);
	}
	
    public static int pathSum1(TreeNode root, int targetSum, boolean resetCnt) {
    	if (resetCnt)	{
    		cnt = 0;
    	}
    	if (root == null)	{
    		return 0;
    	}
		path2(root, 0, targetSum);
		pathSum1(root.left, targetSum, false);
		pathSum1(root.right, targetSum, false);		
    	return cnt;
    }
    
    
    
    public static void path(TreeNode node, int sum, int targetSum)	{
    	logger.log(Level.INFO, node + "," + Integer.toString(sum) + "," + Integer.toString(targetSum));
    	sum = sum + node.val;
    	if (sum == targetSum)	{
    		++cnt;
    		logger.log(Level.INFO, "sum found : " + node.val + "," + cnt);
    	}	else	{
    		if (node.left != null)	{
    			path(node.left, sum, targetSum);
    			//path(node.left, 0, targetSum);
    		}	
    		if (node.right != null)	{
    			path(node.right, sum, targetSum);    			
    			//path(node.right, 0, targetSum);    			
    		}
    	}
    }
    
    public static void path1(TreeNode node, String path, long sum, int targetSum)	{
		//logger.log(Level.INFO, path + "," + node.val + "," +  (sum + node.val == targetSum));
		if (sum + node.val == targetSum)	{
			++cnt;
		}
    	if (node.left == null && node.right == null)	{
    		return ;
    	}
    	if (node.left != null)	{
    		path2(node.left,  sum + node.val, targetSum);
    	}
    	if (node.right != null)	{
    		path2(node.right, sum + node.val, targetSum);
    	}
    }

    public static void path2(TreeNode node, long sum, int targetSum)	{
		//logger.log(Level.INFO, path + "," + node.val + "," +  (sum + node.val == targetSum));
		if (sum + node.val == targetSum)	{
			++cnt;
		}
    	if (node.left == null && node.right == null)	{
    		return ;
    	}
    	if (node.left != null)	{
    		path2(node.left, sum + node.val, targetSum);
    	}
    	if (node.right != null)	{
    		path2(node.right, sum + node.val, targetSum);
    	}
    }
}
