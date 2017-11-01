package OddEvenLL;
class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
		next = null;
	}
}
public class LinkedList {

	 public ListNode oddEvenList(ListNode head) {
		 if(head == null)
			 return null;
	    ListNode oddHead = head;
	    ListNode evenHead = head.next;
	    ListNode oddNext = oddHead;
	    ListNode evenNext = evenHead;
	    
	    while(oddNext!=null && evenNext!=null && evenNext.next!=null) {
	    	oddNext.next = evenNext.next;
	    	evenNext.next = evenNext.next.next;
	    	
	    	oddNext = oddNext.next;
	    	evenNext = evenNext.next;
	    }
	    if(oddNext!=null) {
	    	oddNext.next = evenHead;
	    }
	    return oddHead;
	 }
	 
	 public void printLn(ListNode head) {
		 ListNode n = head;
		 while(n!=null) {
			 System.out.print(n.val+"->");
			 n= n.next;
		 }
		 System.out.print("NIL");
		 System.out.println("\n");
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		l.next.next.next.next.next = new ListNode(6);
		LinkedList ll = new LinkedList();
		ll.printLn(l);
		ListNode res =ll.oddEvenList(l);
		ll.printLn(res);
//		
	}

}
