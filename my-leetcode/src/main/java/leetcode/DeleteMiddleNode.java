package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

/*class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }*/


public class DeleteMiddleNode {
	public static Logger logger = Logger.getLogger(DeleteMiddleNode.class.getName());
	public static void main(String args[])	{
//[1,3,4,7,1,2,6]		
		int arr[] = {1};
		ListNode root = new ListNode(arr[0]);
		ListNode cur = root;
		for (int i =1; i < arr.length; ++i)	{
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		deleteMid(root);
		cur = root;
		while (cur != null)	{
			logger.log(Level.INFO, Integer.toString(cur.val));
			cur = cur.next;
		}
	}
	
	static void deleteMid(ListNode root)	{
		int len = 1;
		ListNode cur = root;
		while(cur.next != null)	{
			cur = cur.next;
			++len;
		}
		if (len == 1)	{
			root = null;
		}
		cur = root;
		int mid = len / 2;
		for (int i = 0; i < mid - 1; ++i)	{
			cur = cur.next;
		}
		cur.next = cur.next.next;
	}
}
