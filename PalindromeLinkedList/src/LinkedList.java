class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int x) {
		x = val;
		next = null;
	}
}
public class LinkedList {
	
	public boolean isPalindrome(ListNode head) {
        ListNode slow,fast;
        slow = fast = head;
        while(fast!=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        // Reverse the Nodes from Slow ptr to fast pointer
        ListNode c = slow;
        
        if(c!=null) {
        	ListNode last = c;
        	ListNode n = c.next;
        	while(n!=null) {
        		ListNode t = n.next;
        		n.next = c;
        		c = n;
        		n = t;
        	}
        	slow = c;
        	last.next = null;
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
	}

}
