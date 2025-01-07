package leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TwinSum {
	public static Logger logger = Logger.getLogger(TwinSum.class.getName());

	public static void main(String args[])	{
		int arr[] = {4,2,2,3};
		ListNode root = new ListNode(arr[0]);
		ListNode cur = root;
		for (int i =1; i < arr.length; ++i)	{
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
		logger.log(Level.INFO, Integer.toString(pairSum(root)));
	}
	
    public static int pairSum(ListNode head) {
    	int len = 0, pos = 1;
    	ListNode cur = head, halfWay, halfWayPrev;
    	while(cur != null)	{
    		++len;
    		cur = cur.next;
    	}
    	//find half point and reverse nodes starting half-point
    	int mid = len / 2;
    	halfWay = head;
    	halfWayPrev = head;
    	while (pos <= mid)	{
    		if(halfWay != head)	{
    			halfWayPrev = halfWayPrev.next;
    		}
    		++pos;
    		halfWay = halfWay.next;	
    	}
    	halfWay = ReverseList.reverseList(halfWay);
    	halfWayPrev.next = halfWay;
    	System.out.println(head.printList());
    	cur = head;
    	pos = 0;
    	int min = Integer.MIN_VALUE;
    	while(pos < mid)	{
    		++pos;
    		logger.log(Level.INFO, cur.val + "," + halfWay.val);
    		if (cur.val + halfWay.val > min)	{
    			min = cur.val + halfWay.val;
    		}
    		cur = cur.next;
    		halfWay = halfWay.next;
    	}
    	//ignore the mid node when list length is odd
    	return min;
    }
}
