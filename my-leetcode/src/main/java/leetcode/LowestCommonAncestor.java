package leetcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class LowestCommonAncestor {
	
	static Map<Integer, Integer> parentMap = new HashMap();

	public static void main(String args[]) throws IOException {
		String s = Files.readString(
				Path.of("src/main/resources/stringperm.txt"),
				StandardCharsets.UTF_8
		);
		String s1[] = s.split(",");
		//TreeNode root = createTree(s1);
		//logger.log(Level.INFO, root.toString());
		//int level = findParentPos(1);
		//logger.log(Level.INFO, Integer.toString(level));
		/*TreeNode root = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);*/
		
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(-1);
		root.right = new TreeNode(-4);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		List<Integer> li = new ArrayList();
		//findPath(root, li);
		TreeNode node1 = lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5));
	}
	
	public static TreeNode createTree(String[] nodes)	{
		TreeNode root = new TreeNode();
		int len = nodes.length;
		if (len == 0)	{
			return null;
		}
	    Queue<TreeNode> parentQueue = new ArrayDeque();
	    root = new TreeNode(Integer.parseInt(nodes[0]));
	    TreeNode curParent = root;
	    for (int i = 1; i < len; i++) {
	    	String node = nodes[i];
	    	if (i%2 == 1)	{
	            if (!node.equalsIgnoreCase("null")) {
	                curParent.left = new TreeNode(Integer.parseInt(node));
	                parentQueue.add(curParent.left);
	            }
	    	}	else	{
	            if (!node.equalsIgnoreCase("null")) {
	                curParent.right = new TreeNode(Integer.parseInt(node));
	                parentQueue.add(curParent.right);
	            }
	    		
	    	}
	    }
		return root;
	}

	/**
	 * 
	 * @param node1
	 * @param root
	 * @return - Parent of node
	 */
	public static TreeNode findParent(TreeNode child, TreeNode root)	{
		if (parentMap.containsKey(child.val))	{
			return new TreeNode(parentMap.get(child.val));
		}
		System.out.println("Into findParent : " + child.val + " : " + root.val);
		if (child.val == root.val)	{
			return root;
		}
		TreeNode node = root;
		TreeNode parent = null;
		int level = 0;
		List<TreeNode> currLevel = new ArrayList(), nextLevel = new ArrayList();
		nextLevel.add(node);
		while(parent == null)	{
			//System.out.println(level + " : " + nextLevel.size());
			currLevel.clear();
			currLevel.addAll(nextLevel);
			nextLevel.clear();
			for (TreeNode tmpNode : currLevel)	{
				if(tmpNode.right != null && tmpNode.right.val == child.val)	{
					parent = tmpNode;
					System.out.println("Parent found : " + parent.val);
					return parent;
				}
				if(tmpNode.left != null && tmpNode.left.val == child.val)	{
					parent = tmpNode;
					System.out.println("Parent found : " + parent.val);
					return parent;
				}
				if (tmpNode.left != null)	{
					parentMap.put(tmpNode.left.val, tmpNode.val);
					nextLevel.add(tmpNode.left);
				}
				if (tmpNode.right != null)	{
					parentMap.put(tmpNode.right.val, tmpNode.val);
					nextLevel.add(tmpNode.right);
				}
			}
		}
		return parent;
	}
	
	//finds path from root to this node
	public static void findPath(TreeNode node, List<Integer> path)	{
		path.add(node.val);
		//pathMap.put(node.val, new ArrayList(path));
		
		if (node.right != null)	{
			findPath(node.right, new ArrayList(path));
		}
		if (node.left != null)	{
			findPath(node.left, new ArrayList(path));
		}
	}
	
	//finds path from root to this node
	public static void findPath(TreeNode root, TreeNode node, List<Integer> path)	{
		path.add(root.val);
		if (root.val == node.val)	{
			System.out.println("Path found : " + node.val + path);
			//pathMap.put(node.val, new ArrayList(path));
			return;
		}		
		if (root.right != null)	{
			findPath(root.right, node, new ArrayList(path));
		}
		if (root.left != null)	{
			findPath(root.left, node, new ArrayList(path));
		}
	}

	
	//compare paths to this each node and finds common ancestor
	/*public static TreeNode findCommonParent(TreeNode node1, TreeNode node2)	{
		findPath
		List<Integer> li1 = pathMap.get(node1.val);
		List<Integer> li2 = pathMap.get(node2.val);
		li1.retainAll(li2);
		//return new TreeNode(li1.get(li1.size() - 1));
		int max = Integer.MIN_VALUE;
		int maxval = -1;
		for (int i : li1)	{
			if (pathMap.get(i).size() > max)	{
				max = pathMap.get(i).size();
				maxval = i;
			}
		}
		return new TreeNode(maxval);
	}*/
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		System.out.println("Into lca method");
		List<Integer> li1 = new ArrayList(), li2 = new ArrayList();
		li1.add(p.val);
		li2.add(q.val);
		TreeNode parent1 = findParent(p, root);
		while (parent1.val != root.val)	{
			li1.add(parent1.val);
			parent1 = findParent(parent1, root);
		}
		li1.add(root.val);
		parent1 = findParent(q, root);
		TreeNode parent2 = findParent(q, root);
		while (parent2.val != root.val)	{
			li2.add(parent2.val);
			parent2 = findParent(parent2, root);
		}
		li2.add(root.val);
		li1.retainAll(li2);
		System.out.println("Solved : " + p.val + " : " + q.val + " : " + li1.get(0));
		return new TreeNode(li1.get(0));
    }
}
