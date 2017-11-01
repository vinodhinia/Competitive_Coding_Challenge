package SwapNodes;



class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
		
	}
}
public class SwapNodes {
	
	public ListNode swapPairs(ListNode head) {
		if(head!=null) {
			ListNode n1 = head;
			ListNode n2= head.next,newHead = head.next;
			ListNode prev = null;
			
			
			while(n1!=null && n2!=null) {
				ListNode t = n2.next;
				n2.next = n1;
				n1.next = t;
				prev = n1;
				n1 = t;
				if(t!=null) {
					n2 = t.next;
					
				}
				else
					break;
			}
			return newHead;  
		}
      return null;
    }

	
	public void printLn(ListNode head) {
		ListNode n = head;
		while(n!=null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwapNodes s = new SwapNodes();
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		ListNode res = s.swapPairs(l);
		s.printLn(res);
	}

}
