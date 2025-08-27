package leetcode;

import java.util.*;

public class RightSideTree {
	
	public static void main(String args[])	{
		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.right = new TreeNode(3);*/
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		List<Integer> li = rightSideView(root);
	}
	
    public static List<Integer> rightSideView(TreeNode root) {
    	if (root == null)	{
    		return new ArrayList<Integer>();
    	}
    	List<TreeNode> right = new ArrayList<>();
    	Queue<TreeNode> currLevel = new ArrayDeque<TreeNode>(), nextLevel =  new ArrayDeque<TreeNode>();
    	right.add(root);
    	currLevel.add(root);
    	do{
    		nextLevel.clear();
    		TreeNode curr = traverse(currLevel, nextLevel);
    		if (curr != null)	{
    			right.add(curr);
    		}
    		currLevel.clear();
    		currLevel.addAll(nextLevel);
    	}	while (!nextLevel.isEmpty());
    	List<Integer> li = new ArrayList<>();
    	for (TreeNode t : right)	{
    		li.add(t.val);
    	}
        return li;
    }
    
    public static TreeNode traverse(Queue<TreeNode> levelQueue, Queue<TreeNode> nextLevel )	{
    	TreeNode thisLevelNode = null;
    	if (levelQueue == null || levelQueue.isEmpty())	{
    		return null;
    	}
    	while(!levelQueue.isEmpty())	{
    		TreeNode curr = levelQueue.remove();
    		if (thisLevelNode == null) {
    			if (curr.right != null)	{
    				thisLevelNode = curr.right;
    			}
    			else if (curr.left != null)	{
    				thisLevelNode = curr.left;
    			}	else {}
    		}
    		if (curr.right != null)	{
    			nextLevel.add(curr.right);
    		}
    		if (curr.left != null)	{
    			nextLevel.add(curr.left);
    		}    		
    	}
    	return thisLevelNode;
    }
    
}
