class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		val = x;
	}
}

public class LinkedList {
	
	 public ListNode merge(ListNode headA,ListNode headB) {
		 ListNode l1 = headA;
		 ListNode l2 = headB;
		 
		 ListNode l3tail = null;
		 ListNode l3head = null;
		 
		 while(l1!=null && l2!=null) {
			 if(l1.val <= l2.val) {
				 if(l3head==null && l3tail == null) {
					 l3head = l3tail = new ListNode(l1.val);
				 }else {
					 l3tail.next = new ListNode(l1.val);
					 l3tail = l3tail.next;
				 }
				 l1 = l1.next;
			 }else if(l1.val > l2.val) {
				 if(l3head == null && l3tail == null) {
					 l3head = l3tail = new ListNode(l2.val);
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
			 l3tail = l3tail.next;
			 l2 = l2.next;
		 }
		return l3head;	
	 }
	 
	 
	 public ListNode sortList(ListNode head) {
		 int len = findLength(head);
		 int n =len/2;
		 if(n < 1)
			 return head;
		  
		 ListNode leftHead=null,rightHead=null;
		 ListNode leftTail=null,rightTail=null;
		 
		 ListNode t = head;
		 int i=0;
		 for(i=0;i<n;i++) {
			 if(leftHead == null && leftTail == null) {
				 leftHead = leftTail = new ListNode(t.val);
			 }else {
				 leftTail.next = new ListNode(t.val);
				 leftTail = leftTail.next;
			 }
			 t = t.next;
		 }
		 
		 for(int k=i;k<(len);k++) {
			 if(rightHead == null && rightTail == null) {
				 rightHead = rightTail = new ListNode(t.val);
			 }else {
				 rightTail.next = new ListNode(t.val);
				 rightTail = rightTail.next;
			 }
			 t = t.next;
		 }
		 
		 leftHead = sortList(leftHead);
		 rightHead = sortList(rightHead);
		 return merge(leftHead, rightHead);
	 }
	 
	 public int findLength(ListNode head) {
		 ListNode l = head;
		 int len =0;
		 while(l!=null) {
			 len++;
			 l = l.next;
		 }
		 return len;
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
	 
	 
	 public void printRec(ListNode node) {
		 if(node == null)
			 return;
		System.out.println(node.val); 
		printRec(node.next);
	 }
	 
	 public void printRev(ListNode node) {
		 
	 }
	 
	 public static String intToRoman(int num){
			if (num < 1 || num > 3999) return "";
			
			StringBuilder result = new StringBuilder();
			
			String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",  "V", "IV", "I"};
			int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
			
			int i = 0;
			while (num >0) {
				while ( num >= values[i]) {
					num -= values[i];
					result.append(roman[i]);
				}
				i++;
			}
			return result.toString();
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(7);
		head.next.next.next  = new ListNode(9);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(1);
		
		LinkedList l =  new LinkedList();
		ListNode resHead = l.sortList(head);
		l.printLn(resHead);
		
		System.out.println(intToRoman(9));
		
	}

}
