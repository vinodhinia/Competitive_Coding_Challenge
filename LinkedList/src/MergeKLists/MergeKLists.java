package MergeKLists;
import java.util.*;

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
		
	}

	public ListNode() {
		// TODO Auto-generated constructor stub
	}
}
public class MergeKLists {
	
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode l3 = null;
        if(lists.length<1)
        	return null;
        List<ListNode> arrayList = new ArrayList<ListNode>();
        for(int i=0;i<lists.length;i++) {
        	if(lists[i]!=null)
        		arrayList.add(lists[i]);
        }
        if(arrayList.size()<1)
        	return null;
        
        while(arrayList.size()!=1) {
        	ListNode l1 = arrayList.remove(0);
        	ListNode l2 = arrayList.remove(0);
        	 l3 = mergeList(l1,l2);
        	arrayList.add(l3);
        }
        if(arrayList.size()==1) {
        	l3 = arrayList.remove(0);
        }
        return l3;
    }
	
	public ListNode mergeList(ListNode l1, ListNode l2) {
		ListNode l3Head= null,l3tail=null;
		while(l1!=null && l2!=null) {
			if(l1.val < l2.val) {
				if(l3Head == null && l3tail == null) {
					l3Head = l3tail = new ListNode(l1.val);
				}else {
					l3tail.next = new ListNode(l1.val);
					l3tail = l3tail.next;
				}
				l1 = l1.next;
			}else if(l1.val > l2.val) {
				if(l3Head == null && l3tail == null) {
					l3Head = l3tail = new ListNode(l2.val);
				}else {
					l3tail.next = new ListNode(l2.val);
					l3tail = l3tail.next;
				}
				l2 = l2.next;
			}
		}
		
		while(l1!=null) {
			l3tail.next = new ListNode(l1.val);
			l3tail = l3tail.next;
			l1 = l1.next;
		}
		while(l2!=null) {
			l3tail.next = new ListNode(l2.val);
			l2 = l2.next;
			l3tail = l3tail.next;
		}
		return l3Head;
	}
	
	public void printLn(ListNode head) {
		ListNode n = head;
		while(n!=null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
	}

	public static void main(String[] args	) {
		// TODO Auto-generated method stub
		MergeKLists m = new MergeKLists();
		ListNode l1 = null;
//		l1.next = new ListNode(2);
//		l1.next.next = new ListNode(3);
		
		ListNode l2 = null;
//		l2.next = new ListNode(5);
//		l2.next.next = new ListNode(6);
		
//		ListNode l3 = new ListNode(7);
//		l3.next = new ListNode (8);
		
		ListNode[] lists = {l1,l2};
		ListNode res = m.mergeKLists(lists);
		m.printLn(res);
	}

}
