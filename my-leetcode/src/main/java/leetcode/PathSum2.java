package leetcode;

import java.util.*;
//import java.util.logging.Logger;

public class PathSum2 {
	
	public static void main(String args[])	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(-1);
		root.right.left = new TreeNode(-2);
		System.out.println(pathSum(root, -1));
	}

	public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public static int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        System.out.println(currSum + "," + target + "," + root.val);
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
    
}
