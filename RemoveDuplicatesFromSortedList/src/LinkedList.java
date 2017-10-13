class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
	}
}
public class LinkedList {
	public static ListNode head;
	public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while(current!=null) {
        	if(current.next!=null) {
        		if(current.val == current.next.val) {
        			current.next = current.next.next;
        		}else {
        			current = current.next;
        		}
        	}else {
        		current.next =  null;
        		current = current.next;
        	}
        	
        }
        return head;
    }
	
	  public ListNode removeElements(ListNode head, int val) {
	        
	    }
	
	public void printLn() {
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
		head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next =  new ListNode(1);
		l.printLn();
		
		l.deleteDuplicates(head);
		l.printLn();
	}

}
