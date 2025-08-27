package leetcode;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteTreeNode {
	public static Logger logger = Logger.getLogger(DeleteTreeNode.class.getName());
	
	public static void main(String args[])	{
		DeleteTreeNode d = new DeleteTreeNode();
		TreeNode root = new TreeNode(5);
		root.right = new TreeNode(3);
		root.left = new TreeNode(6);
		root.right.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		root.left.left = new TreeNode(7);
		logger.log(Level.INFO, root.printTree());
		d.deleteNode(root, 7);
		logger.log(Level.INFO, root.printTree());
		
	}


	
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)	{
			return root;
		}
    	if (root.val == key)	{
    		if (root.right != null)	{
    			if (root.left != null)	{
    				root.right.left = root.left;
    			}
    			return root.right;
    		}
    		if (root.left != null)	{
    			if (root.right != null)	{
    				root.left.right = root.right;
    			}
    			return root.left;
    		}
    		return null;
    	}
    	//find key
    	List<TreeNode> curr = new ArrayList<TreeNode>(), nextLevel = new ArrayList<TreeNode>();
    	TreeNode found = null, parent = null;
    	curr.add(root);
    	while(!curr.isEmpty())	{
    		if (found != null)	{
    			break;
    		}
    		for (TreeNode node : curr)	{
    			if (node.right != null && node.right.val == key)	{
    				parent = node;
    				found = node.right;
    			}
    			if (node.left != null && node.left.val == key)	{
    				parent = node;
    				found = node.left;
    			}
    			if (node.right != null)	{
    				nextLevel.add(node.right);
    			}
    			if (node.left != null)	{
    				nextLevel.add(node.left);
    			}
    		}
    		curr.clear();
    		curr.addAll(nextLevel);
    		nextLevel.clear();
    	}
    	
    	//delete if key is found
    	if (found != null)	{
    		if (found.right != null)	{
    			if (found.left != null)	{
    				found.right.left = found.left;
    			}
    			if (parent.right == found)	{
    				parent.right = found.right;
    			}	else	{
    				parent.left = found.right;
    			}
    		}	else if (found.left != null)	{
    			if (parent.right == found)	{
    				parent.right = found.left;
    			}	else	{
    				parent.left = found.left;
    			}
    		}	else	{
    			//if found is a terminal node
    			if (parent.right == found)	{
    				parent.right = null;
    			}	else	{
    				parent.left = null;
    			}
    			
    		}
    	}
    	
    	return root;
    }
    
    

}
