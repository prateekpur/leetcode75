package leetcode;

import java.util.*;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public String toString()	{
		String s = "val : " + Integer.toString(val) ;
		if (left != null)	{
			s += "  left ," + left.val;
		}
		if (right != null)	{
			s += " right ," + right.val;
		}
		return s;
	}
	
	public String printTree()	{
		String s = "";
		List<TreeNode> curr = new ArrayList<TreeNode>(), next = new ArrayList<TreeNode>();
		curr.add(this);
		while (!curr.isEmpty())	{
			for (TreeNode n : curr)	{
				s += n.val + ",";
				if (n.right != null)	{
					next.add(n.right);
				}
				if (n.left != null)	{
					next.add(n.left);
				}
			}
			curr.clear();
			curr.addAll(next);
			next.clear();
		}
		return s;
	}
}
