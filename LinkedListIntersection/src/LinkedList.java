import java.util.HashMap;

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
	}
}
public class LinkedList {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode l1 = headA;
        while(l1!=null) {
        	map.put(l1.val, l1.next);
        	l1 = l1.next;
        }
        
        ListNode l2 = headB;
        
        while(l2!=null) {
        	if(map.containsKey(l2.val)) {
        		return l2;
        	}
        	l2 = l2.next;
        }
        return null;
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
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(2);
		
		headA.next = new ListNode(3);
		headA.next.next = new ListNode(5);
		headA.next.next.next = new ListNode(7);
		headA.next.next.next.next = new ListNode(9);
		
		headB.next = new ListNode(4);
		headB.next.next = new ListNode(7);
		headB.next.next.next = new ListNode(11);
		
		LinkedList l = new LinkedList();
		l.printLn(headA);
		l.printLn(headB);
		
		System.out.println(l.getIntersectionNode(headA, headB).val);
	}

}
