package RotateList;



class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
		next = null;
	}
}
public class LinkedList {

	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
        	return null;
        if(k==0)
        	return  head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(k>1) {
        	fast = fast.next;
        	k--;
        }
        
        while(fast!=null && fast.next!=null) {
        	prev = slow;
        	slow = slow.next;
        	fast = fast.next;
        }
        
        if(prev == null)
        	return head;
        fast.next = head;
        prev.next = null;
        return slow;
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
//		l.next.next = new ListNode(3);
//		l.next.next.next = new ListNode(4);
//		l.next.next.next.next = new ListNode(5);
//		//l.next.next.next.next.next = new ListNode(6);
		LinkedList ll = new LinkedList();
		ll.printLn(l);
		
		ListNode r = ll.rotateRight(l, 0);
		ll.printLn(r);
	}

}
