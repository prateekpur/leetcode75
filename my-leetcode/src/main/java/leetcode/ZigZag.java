package leetcode;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZigZag {
	enum Direction{LEFT, RIGHT};
	public static Logger logger = Logger.getLogger(ZigZag.class.getName());
	
	public static void main(String args[])	{
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		root.right.right.left.right = new TreeNode(7);
		root.right.right.left.right.right = new TreeNode(8);
		/*root.right = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.left.right = new TreeNode(6);
		root.right.left.right.right = new TreeNode(7);*/
		/*root.right = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.left = null;
		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(6);*/
		int cnt = startZig(root);
		logger.log(Level.INFO, Integer.toString(cnt));
	}
	
	public static int startZig(TreeNode root)	{
		logger.log(Level.INFO, root.toString());
		int max = 0;
		int cnt = 0;
		cnt = countZig(root, Direction.LEFT);
		if (cnt > max)	{
			max = cnt;
		}
		cnt = countZig(root, Direction.RIGHT);
		if (cnt > max)	{
			max = cnt;
		}
		List<TreeNode> li = new ArrayList();
		if (root.right != null)	{
			li.add(root.right);
		}
		if (root.left != null)	{
			li.add(root.left);
		}
		while (!li.isEmpty())	{
			List<TreeNode> litmp = new ArrayList();
			for (TreeNode node : li)	{
				logger.log(Level.INFO, node.toString());
				cnt = countZig(node, Direction.LEFT);
				if (cnt > max)	{
					max = cnt;
				}
				cnt = countZig(node, Direction.RIGHT);
				if (cnt > max)	{
					max = cnt;
				}
				if (node.right != null)	{
					litmp.add(node.right);
				}
				if (node.left != null)	{
					litmp.add(node.left);
				}
			}
			li.clear();
			li.addAll(litmp);
		}
		return max;
	}
	
	//dir is the direction followed for reaching this node
	public static int countZig(TreeNode node, Direction dir)	{
		if (dir == Direction.RIGHT)	{
			if (node.left == null)	{
				//logger.log(Level.INFO, node + " , " + dir + " : 0");
				return 0;
			}	else	{
				int cnt = 1 + countZig(node.left, Direction.LEFT);
				//logger.log(Level.INFO, node + " , " + dir + " : " + cnt);
				return cnt;
			}
		}	else	{
			if (node.right == null)	{
				//logger.log(Level.INFO, node + " , " + dir + " : 0");
				return 0;
			}	else	{
				int cnt = 1 + countZig(node.right, Direction.RIGHT);
				//logger.log(Level.INFO, node + " , " + dir + " : " + cnt);
				return cnt;
			}
		}
	}
}
