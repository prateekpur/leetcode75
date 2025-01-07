package leetcode;

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
			s += " left ," + left.val;
		}
		if (right != null)	{
			s += " right ," + right.val;
		}
		return "val : " + Integer.toString(val) ;
	}
}
