package ReverseLinkedList;
class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
}
public class ReverseLinkedList {

	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode prev= null;
        while(m!=1) {
        	prev = curr;
        	curr = curr.next;
        	m--;
        }
        ListNode last = curr;
        ListNode nex = null,t =null;
        if(curr!=null)
        	nex = curr.next;
        while(n!=2 && nex!=null) {
        	 t = nex.next;
        	nex.next =  curr;
        	curr = nex;
        	nex = t;
        	n--;
        }
        if(prev!=null)
        	prev.next = curr;
        last.next = t;
        return head;
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
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode h =r.reverseBetween(l, 1, 4);
		r.printLn(h);
	}

}
