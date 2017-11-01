package AddLinkedList;

import java.util.Stack;

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
	}
}
public class LinkedList {
	
	public int findLength(ListNode head) {
		int len = 0;
		ListNode n = head;
		while(n!=null) {
			len++;
			n = n.next;
		}
		return len;
	}
	
	public ListNode padding(ListNode head,int val) {
		ListNode h = head;
		ListNode tail;
		
		while(h!=null && h.next!=null) {
			h =  h.next;
		}
		
		while(val!=0) {
			ListNode t = new ListNode(0);
			h.next = t;
			h = h.next;
			val--;
			
		}
		return head;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Len = findLength(l1);
        int l2Len = findLength(l2);
        LinkedList l3 = new LinkedList();
        ListNode head = null,tail = null;
        if(l1Len < l2Len)
        	l1 = padding(l1, l2Len - l1Len);
        else if(l2Len < l1Len)
        	l2 = padding(l2, l1Len - l2Len);
        
        printLn(l1);
        printLn(l2);
        int carry = 0;
        
        while(l1!=null) {
        	int sum = l1.val + l2.val + carry;
        	if(sum > 9) {
        		carry = 1;
        		int digit = sum%10;
        		if(head == null && tail == null)
        			head = tail = new ListNode(digit);
        		else {
        			ListNode t= new ListNode(digit);
        			tail.next = t;
        			tail = tail.next;
        		}
        			//l3.tail = insert(digit);
        	}else {
        		carry = 0;
        		if(head == null && tail == null)
        			head = tail = new ListNode(sum);
        		else {
        			ListNode t= new ListNode(sum);
        			tail.next = t;
        			tail = tail.next;
        		}
        			//l3.tail = insert(sum);
        	}
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        if(carry == 1) {
        	ListNode t= new ListNode(1);
			tail.next = t;
			tail = tail.next;
        }
        	
        printLn(head);
        	
        return head;
    }
	
	
	public void printLn(ListNode head) {
		ListNode n = head;
		while(n!=null) {
			System.out.print(n.val + "-> ");
			n = n.next;
		}
		System.out.print("NIL");
		System.out.println("\n");
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        
        while(n!=1) {
        	fast = fast.next;
        	n--;
        }
        while(fast!=null && fast.next!=null) {
        	prev = slow;
        	slow =  slow.next;
        	fast = fast.next;
        }
        slow.next = slow.next.next;
        
       // prev.next = slow.next;
        return head;
    }	
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1!=null) {
        	s1.push(l1.val);
        	l1 = l1.next;
        }
        
        while(l2!=null) {
        	s2.push(l2.val);
        	l2 = l2.next;
        }
        
        ListNode head = null,tail =null;
        Stack<Integer> s3 = new Stack<Integer>();
        int carry = 0;
        while(!s1.isEmpty() && !s2.isEmpty()) {
        	int sum = carry + s1.pop() + s2.pop();
        	if(sum > 9) {
        		int rem = sum % 10;
        		carry = 1;
        		s3.push(rem);
        		
        	}else {
        		carry = 0;
        		s3.push(sum);
        	}
        }
        
        while(!s1.isEmpty()) {
        	int sum = s1.pop() + carry;
        	if(sum > 9) {
        		carry = 1;
        		s3.push(sum%10);
        	}else {
        		s3.push(sum);
        		carry = 0;
        	}
        		
        }
        while(!s2.isEmpty()) {
        	int sum =  s2.pop() + carry;
        	if(sum > 9) {
        		carry = 1;
        		s3.push(sum%10);
        	}else {
        		carry = 0;
        		s3.push(sum);
        	}
        }
        if(carry == 1)
        	s3.push(1);
        while(!s3.isEmpty()) {
        	if(head == null && tail == null) {
        		head = tail = new ListNode(s3.pop());
        	}else {
        		tail.next = new ListNode(s3.pop());
        		tail = tail.next;
        	}
        }
        
		return head;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList a = new LinkedList();
		ListNode l1 = new ListNode(1);
		l1.next =  new ListNode(8);
		l1.next.next =  new ListNode(3);
		//a.printLn(l1);
		
		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		//a.printLn(l2);
		
		ListNode resHead = a.addTwoNumbers(l1, l2);
		
		a.printLn(resHead);
		
		
		System.out.println("Remove a Node from end of the linkedList");
		LinkedList l = new LinkedList();
		ListNode n = new ListNode(1);
		//n.next = new ListNode(2);
		//n.next.next = new ListNode(3);
//		n.next.next.next = new ListNode(4);
//		n.next.next.next.next = new ListNode(5);
		//ListNode r = a.removeNthFromEnd(n, 1);
		//a.printLn(r);
		
		
		System.out.println("Adding two number with out reversing the list");
		ListNode l3 = new ListNode(9);
		l3.next =  new ListNode(9);
//		l3.next.next =  new ListNode(4);
//		l3.next.next.next =  new ListNode(3);
		
		a.printLn(l3);
		
		ListNode l4 = new ListNode(1);
//		l4.next = new ListNode(6);
//		l4.next.next = new ListNode(4);
		a.printLn(l4);
		ListNode result = a.addTwoNumbers2(l3, l4);
		System.out.println("Sum of two numbers");
		a.printLn(result);
	}

}
