import java.util.*;

class Tree<T> {
   Tree(T x) {
     value = x;
   }
   T value;
   Tree<T> left;
   Tree<T> right;
 }
 
 
public class Solution {
	
	
	int[] largestValuesInTreeRows(Tree<Integer> t) {
	    int[] arr = new int[0];
	    if( t == null)
	        return arr;
	    Queue<Tree<Integer>> q = new LinkedList<Tree<Integer>>();
	    List<Integer> list = new ArrayList<Integer>();
	    List<Integer> resultList = new ArrayList<Integer>();
	    q.offer(t);
	    int counter1 = 1, counter2 = 0;
	    int max = Integer.MIN_VALUE;
	    
	    while(!q.isEmpty()){
	        list = new ArrayList<Integer>();
	        while(counter1 > 0){
	            Tree<Integer> r = q.poll();
	            list.add(r.value);
	            if(r.left != null){
	                q.offer(r.left);
	                counter2++;
	            }
	            if(r.right != null){
	                q.offer(r.right);
	                counter2++;
	            }
	            counter1--;
	        }
	        //System.out.println(counter1);
	        if(counter1 == 0){
	        	max = Integer.MIN_VALUE;
	            for(Integer l : list){
	                max = Math.max(max, l);
	            }
	            resultList.add(max);
	            counter1 = counter2;
	            counter2 = 0;
	        }
	    }
	    
	    int[] res = new int[resultList.size()];
	    int i=0;
	    for(Integer l : resultList){
	        res[i++] = l;
	    }
	    return res;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Tree t = new Tree(-1);
		t.left = new Tree(5);
		t.right = new Tree(7);
		t.right.right = new Tree(1);
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		
		int[] r = s.largestValuesInTreeRows(t);
		for(int i=0;i<r.length;i++)
			System.out.println(r[i]);
	}

}
