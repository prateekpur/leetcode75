package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

//https://leetcode.com/problems/odd-even-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
public class OrderLinkedList {
	public static Logger logger = Logger.getLogger(OrderLinkedList.class.getName());
	public static void main(String args[])	{
		int arr[] = {2,1,3,5,6,4,7};
		ListNode root = new ListNode(arr[0]);
		ListNode cur = root;
		for (int i =1; i < arr.length; ++i)	{
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		orderList(root);
		cur = root;
		while (cur != null)	{
			logger.log(Level.INFO, Integer.toString(cur.val));
			cur = cur.next;
		}
	}
	
	static ListNode orderList(ListNode head)	{
		//if list length < 2 then its already ordered , do nothing
		if (head == null || head.next == null || head.next.next == null)	{
			return head;
		}
		ListNode lastOdd = head, headEven = head.next, lastEven = head.next, current = head.next.next;
		int cnt = 3;
		while(current!=null)	{
			ListNode next = current.next;
			if (cnt %2 == 1)	{
				lastOdd.next = current;
				lastEven.next = current.next;
				lastOdd = current;
				lastOdd.next = headEven;
				lastEven = lastEven.next;
			}
			current = next;
			++cnt;
			logger.log(Level.INFO, head.printList());
		}
        return head;
	}
}
