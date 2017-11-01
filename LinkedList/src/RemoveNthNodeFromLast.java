

public class RemoveNthNodeFromLast {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int len = 0;
        while(node!=null) {
        	len++;
        	node = node.next;
        }
       
        ListNode prev = null;
        ListNode curr = head;
        
        int diff = len - n;
        if(diff == 0) {
        	head = head.next;
        	return head;
        }
        	
        for(int i=0;i<(len-n-1);i++) {
        	prev = curr;
        	curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

	public void printLn(ListNode head) {
		ListNode n = head;
		while(n!=null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}

	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		RemoveNthNodeFromLast r = new RemoveNthNodeFromLast();
		//System.out.println(r.removeNthFromEnd(head, 2).val);
		r.printLn(r.removeNthFromEnd(head, 2));
	}
}
