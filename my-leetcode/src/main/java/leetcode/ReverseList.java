package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ReverseList {
	public static Logger logger = Logger.getLogger(ReverseList.class.getName());
	public static void main (String args[])	{
		int arr[] = {};
		ListNode root = new ListNode(arr[0]);
		ListNode cur = root;
		for (int i =1; i < arr.length; ++i)	{
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		root = reverseList(root);
		logger.log(Level.INFO, root.printList());
	}
	
    public static ListNode reverseList(ListNode head) {
    	//if block to cover empty list or list with 1 element
    	if (head == null || head.next == null)	{
    		return head;
    	}
    	//cover list with length = 2
    	if (head.next.next == null)	{
    		ListNode sec = head.next;
    		sec.next = head;
    		head.next = null;
    		return sec;
    	}
    	ListNode prev = head, curr = head.next, next = head.next.next;
    	while (curr.next != null)	{
    		ListNode tmp = curr;
    		curr.next = head;
    		head = curr;
    		prev.next = next;
    		//prev = curr;
    		curr = next;
    		if (curr.next != null)	{
        		next = curr.next;
    		}	else	{
    			next  = null;
    		}
    		//logger.log(Level.INFO, tmp.printList());
    	}
    	//reverse last element
    	curr.next = head;
    	prev.next = null;
    	head = curr;
    	return head;
    }
}
