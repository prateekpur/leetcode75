package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public String printList()	{
    	ListNode curr = this;
    	StringBuilder bld = new StringBuilder("");
    	while (curr.next != null)	{
    		bld.append(",");
    		bld.append(Integer.toString(curr.val));
    		curr = curr.next;
    	}
		bld.append(",");
		bld.append(Integer.toString(curr.val));
    	return bld.toString();
    }
}
