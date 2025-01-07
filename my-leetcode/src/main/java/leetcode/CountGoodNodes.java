package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CountGoodNodes {
	public static Logger logger = Logger.getLogger(CountGoodNodes.class.getName());
	static int cnt = 0;
	
	public static void main(String args[])	{
		Integer in[] = {3,1,4,3,null,1,5};
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.right.left = null;
		root.left.right = new TreeNode(1);
		root.left.left = new TreeNode(5);
		/*TreeNode root = new TreeNode(3);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(2);*/
		//TreeNode root = new TreeNode(1);
		logger.log(Level.INFO, Integer.toString(goodNodes(root)));
		//logger.log(Level.INFO, Integer.toString(path(root, root.val)));
	}

    public static int goodNodes(TreeNode root) {
    	return path(root, root.val);
    }
    
    public static int path(TreeNode node, int max)	{
    	//logger.log(Level.INFO, Integer.toString(node.val) + "," + Integer.toString(max) + "," + Integer.toString(cnt));
    	if (max <= node.val)	{
    		//logger.log(Level.INFO, "max greater");
    		++cnt;
    	}
    	max = Math.max(max, node.val);
    	if (node.left != null)	{
    		path(node.left, max);
    	}
    	if (node.right != null)	{
    		path(node.right, max);
    	}
    	return cnt;
    }
}
