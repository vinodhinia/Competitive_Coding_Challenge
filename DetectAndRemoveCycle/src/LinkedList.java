class ListNode{
	int val;
	ListNode next;
	
	ListNode(int s){
		val = s;
		next = null;
	}
}
public class LinkedList {
	
	public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow!=null && fast!=null && fast.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	
        	if(slow == fast) {
        		return removeCycle(slow, head);
        	}
        }
        return null;
    }
	
	public ListNode removeCycle(ListNode loopNode, ListNode head) {
		ListNode ptr1 = head;
		ListNode ptr2 = loopNode;
		
		while(true) {
			ptr2 = loopNode;
			while(ptr2.next!=loopNode && ptr2.next!=ptr1) {
				ptr2 = ptr2.next;
			}
			if(ptr2.next == ptr1)
				break;
			ptr1 = ptr1.next;
		}
		return ptr2;
	}
	
	public void printLn(ListNode head) {
		ListNode n = head;
		while(n!=null) {
			System.out.print(n.val + "->");
			n = n.next;
		}
		System.out.print("NIL");
		System.out.println("\n");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		ListNode head = new ListNode(5);
		ListNode t = head.next = new ListNode(4);
		head.next.next = new ListNode(7);
		head.next.next.next  = new ListNode(9);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = t;
		
		System.out.println(l.detectCycle(head).val);
	}

}
