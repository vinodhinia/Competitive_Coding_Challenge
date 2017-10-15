import java.util.*;
 class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { 
		 val = x; 
//		 next = null;
		 }
 }
 	
public class LinkedList {

	public ListNode head = null;
	
	public boolean isPalindrome(ListNode head) {
		if(head == null)
			return true;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = reverseList(slow.next);
		slow = slow.next;
		
		while(slow!=null){
			if(slow.val!=head.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
    }
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l1Head = l1;
		ListNode l2Head = l2;
		ListNode l3 = null;
		ListNode l3Head = null;
		
		while(l1!=null && l2!=null) {
			if(l1.val < l2.val) {
				if(l3 == null) {
					l3 = new ListNode(l1.val);
					l3Head = l3;
				}else {
					l3.next = new ListNode(l1.val);
					l3 = l3.next;
				}
				
				
				l1 = l1.next;
			}else {
				if(l3 == null)
				{
					l3 = new ListNode(l2.val);
					l3Head = l3;
				}
				else {
					l3.next = new ListNode(l2.val);
					l3 = l3.next;
				}
				l2 = l2.next;
			}
		}
		while(l1!=null) {
			if(l3 == null) {
				l3 = new ListNode(l1.val);
				l3Head = l3;
			}else {
				l3.next = new ListNode(l1.val);
				l3 = l3.next;
			}
			l1 = l1.next;
		}
		while(l2!=null) {
			if(l3 == null) {
				l3 = new ListNode(l2.val);
				l3Head = l3;
			}else {
				l3.next =  new ListNode(l2.val);
				l3 = l3.next;
			}
			l2 = l2.next;
		}
		return l3Head;
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode c = head;
		if(c!=null) {
			ListNode last = c;
			ListNode n = c.next;
			while(n!=null) {
				ListNode t = n.next;
				n.next = c;
				c = n;
				n = t;
			}
			head = c;
			last.next =  null;
			return head;
		}
		return null;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1head =  reverseList(l1);
        ListNode l2head = reverseList(l2);
        
        int l1Len = findLength(l1);
		int l2Len = findLength(l2);
		int diff = Math.abs(l1Len - l2Len);
		
		if(l1Len < l2Len) {
			l1 = padding(l1,diff);
		}else if(l2Len < l1Len) {
			l2 	 = padding(l1,diff);
		}
			
        return null;
    }
	
	public List<Integer> findDisappearedNumbers(int[] a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = a.length;
        Arrays.sort(a);
        if(a.length == 1) {
        	int i = 1;
        	while(i!=a[0]) {
        		list.add(i++);
        	}
        	return list;
        }
        for(int i=1;i<a.length;i++) {
        	int diff = a[i] - a[i-1];
        	if(diff >1) {
        		int t = a[i-1];
        		while(diff!=1) {
        			t +=1;
        			diff--;
        			list.add(t);
        		}
        	}
        }
        if(a.length > 0) {
        	int diss = a.length - a[a.length-1];
            if(diss >= 1) {
            	int t = a[a.length - 1];
            	while(diss !=0) {
            		t+=1;
            		diss--;
            		list.add(t);
            	}
            }
        }
        
        return list;
    }
	
	public int removeElement(int[] nums, int val) {
		int begin = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[begin] = nums[i];
				begin++;
			}
		}
		return begin;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        List<Integer> inner = new ArrayList<Integer>();
        
        Set<Integer> seen = new HashSet<Integer>();
        
        for(int i=0;i<nums.length-1;i++) {
        	for(int j=i+1;j<nums.length;j++) {
        		int target  = nums[i] + nums[j];
        		if(seen.contains(-target)) {
        			inner.add(nums[i]);
        			inner.add(nums[j]);
        			inner.add(-target);
        			outer.add(inner);
        			inner = new ArrayList<Integer>();
        			seen.remove(-target);
        		}else {
        			seen.add(nums[j]);
        		}
        	}
        }
        return outer;
    }
	
	
	public ListNode padding(ListNode l,int n) {
		ListNode first = l;
		while(n!=0) {
			ListNode temp =  new ListNode(0);
			temp.next = first;
			first = temp;
			n--;
		}
		return first;
	}
	
	public int findLength(ListNode head) {
		ListNode n = head;
		int count = 0;
		while(n!=null) {
			count++;
			n = n.next;
		}
		return count;
	}
	
	public void printLn(ListNode head) {
		ListNode n = head;
		while(n!=null) {
			System.out.print(n.val + " ");
			n =  n.next;
		}
		System.out.println("\n");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList l = new LinkedList();
////		l.head = new ListNode(1);
////		l.head.next = new ListNode(4);
////		l.head.next.next = new ListNode(6);
//		//l.head.next.next.next = new ListNode(1);
//		l.printLn(l.head);
//		//l.head = l.reverseList(l.head);
//		//l.printLn(l.head);
//		System.out.println(l.isPalindrome(l.head));
//		
//		
//		LinkedList l2 = new LinkedList();
//		l2.head =  new ListNode(1);
//		l2.head.next = new ListNode(2);
//		l2.head.next.next = new ListNode(4);
//		l2.printLn(l2.head);
//		
//		l.printLn(l.mergeTwoLists(l.head, l2.head));
		
		
		LinkedList l = new LinkedList();
		int[] a =  {1,1};
		List<Integer> list = l.findDisappearedNumbers(a);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	

}
