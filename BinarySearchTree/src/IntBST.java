import java.util.*;
class Node{
	int data;
	Node parent;
	Node left;
	Node right;
	
	public Node(int x) {
		data = x;
		parent = null;
		left = null;
		right = null;
	}
}
public class IntBST {
	
	public Node root;
	public static final int NULL = -9999999;
	
	public IntBST() {
		root = null;
	}
	
	// InOrder Recursion 
	public void inOrderTreeWalk(Node root) {
		if(root!=null) {
			inOrderTreeWalk(root.left);
			System.out.println(root.data);
			inOrderTreeWalk(root.right);
		}
	}
	
	//Minimum in Binary Search Tree
	public Node treeMinimum(Node root) {
		Node r = root;
		while(r.left!=null) {
			r = r.left;
		}
		return r;
	}
	
	//Maximum in BinarySearch Tree
	public Node treeMaximum(Node x) {
		while(x.right!=null)
			x = x.right;
		return x;
	}
	
	//Search in Binary Search Tree
	public Node treeSearch(Node x, int k) {
		if(x==null || k == x.data)
			return x;
		if(k < x.data)
			return treeSearch(x.left, k);
		else 
			return treeSearch(x.right, k);
		
	}
	
	// Sucessor
	public Node treeSucessor(Node x) {
		if(x.right!=null)
			return treeMinimum(x.right);
		Node parent = x.parent;
		while(parent!=null && parent.right == x) {
			x = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	
	public void insert(int x) {
		Node n = new Node(x);
		if(root == null)
			root = n;
		else {
			Node r = root;
			
			while(r!=null) {
				Node p = r;
				if(r.data < x) {
					r = r.right;
					if(r == null) {
						p.right = n;
						n.parent =  p;
						break;
					}
				}else {
					r = r.left;
					if(r == null) {
						p.left =  n;
						n.parent = p;
						break;
					}
				}
			}
			
			
		}
	}
	
	
	public int findSecondMinimumValue(Node root) {
        Set<Integer> s = new TreeSet<Integer>();
        s = dfs(root,s);
        Iterator<Integer> it = s.iterator();
        int count = 0;
        while(it.hasNext()){
            count++;
            if(count == 2){
                Integer x = it.next();
                return (int)x;
            }
        }
		return -1;
    }
    
    public Set<Integer> dfs(Node r, Set<Integer> s){
        if(r!=null){
            s.add(r.data);
            dfs(r.left, s);
            dfs(r.right, s);
        }
        return s;
    }
    
    public void levelOrderTraversal() {
    	Node r = root;
    	Queue<Node> q = new LinkedList();
    	q.add(r);
    	int counter1=1,counter2=0;
    	while(!q.isEmpty()) {
    		r = q.poll();
    		System.out.print(r.data + " ");
    		if(r.left!=null) {
    			q.add(r.left);
    			counter2++;
    		}
    		if(r.right!=null) {
    			q.add(r.right);
    			counter2++;
    		}
    		if(--counter1 == 0) {
    			System.out.println("\n");
    			counter1 = counter2;
        		counter2 = 0;
    		}
    		
    		
    	}
    }
    
    public int[] findMode(Node root) {
        Stack<Node> s = new Stack<Node>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(root == null)
        	return new int[0];
        if(root!=null) {
        Node r = root;
        s.push(r);
        
        while(!s.isEmpty()) {
        	r = s.pop();
        	map.put(r.data, map.getOrDefault(r.data, 0)+1);
        	
        	if(r.right!=null) {
        		s.push(r.right);
        	}
        	if(r.left!=null) {
        		s.push(r.left);
        	}
        }
        
        if(map.size()==1) {
        	int[] res  = new int[1];
        	res[0] = root.data;
        	return res;
        }
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> m:map.entrySet()) {
        	if(m.getValue() > max) {
        		max = m.getValue();
        		if(!list.isEmpty())
        			list.remove(0);
        		list.add(m.getKey());
        	}
        }
        if(map.size()!=0 && list.size()==0) {
        	list.addAll(map.keySet());
        }
        int[] res = new int[list.size()];
        int i=0;
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()) {
        res[i] = it.next();
        i++;
        }
        return res;
    }
     
      return null;  
    }
    
    public boolean findTarget(Node root, int k) {
        Set<Integer> seen = new TreeSet<Integer>();
        Stack<Node> s = new Stack<Node>();
        Node r = root;
        s.push(r);
        while(!s.isEmpty()) {
        	r = s.pop();
        	int target = k - r.data;
        	if(!seen.contains(target)) {
        		seen.add(r.data);
        	}else {
        		return true;
        	}
        	if(r.right!=null) {
        		s.push(r.right);
        	}
        	if(r.left!=null) {
        		s.push(r.left);
        	}
        }
		return false;
    }
    
    public List<Double> averageOfLevels(Node root) {
    	List<Double> list = new ArrayList<Double>();
        Queue<Node> q = new LinkedList();
        q.add(root);
        int counter1=1,counter2=0, t=1;
        int sum=0;
        double avg = 0;
        while(!q.isEmpty()) {
        	Node r = q.poll();
        	System.out.print(r.data + " ");
        	sum +=r.data;
        	if(r.left!=null) {
        		counter2++;
        		q.add(r.left);
        	}
        	if(r.right!=null) {
        		counter2++;
        		q.add(r.right);
        	}
        	
        	
        	if(--counter1 == 0) {
        		System.out.println("\n");
        		if(t==1)
        			avg = sum;
        		else 
        			avg = sum/(double)t;
        		list.add(avg);
        		counter1 = counter2;
        		t = counter2;
        		counter2 = 0;
        		sum =0;
        	}
        	
        }
		return list;
    }
    
    
    public int sumOfLeftLeaves(Node root) {
        Stack<Node> s = new Stack<Node>();
        if(root == null)
        	return 0;
        s.add(root);
        int sum =0 ;
        while(!s.isEmpty()) {
        	Node r = s.pop();
        	if(r.left!=null) {
        		if(r.left.left==null && r.left.right==null) {
        			sum += r.left.data; 
        		}
        	}
        	if( r.right!=null) {
        		if(r.right.left!=null || r.right.right!=null) {
        			s.push(r.right);
        		}
        	}
        }
        return sum;
    }
    
    public boolean isSameTree(Node root1, Node root2) {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        if(root1==null || root2==null)
        	return false;
        if(root1.data!=root2.data)
        	return false;
        
        s1.push(root1);
        s2.push(root2);
        
        while(!s1.isEmpty() && !s2.isEmpty()) {
        	Node r1 = s1.pop();
        	Node r2 = s2.pop();
        	
        	if(r1.left!=null && r2.left!=null) {
        		if(r1.left.data !=r2.left.data)
        			return false;
        		else {
        			s1.add(r1.left);
        			s2.add(r2.left);
        		}
        			
        	}else {
        		if((r1.left==null && r2.left!=null) || (r1.left!=null && r2.left==null))
        			return false;
        	}
        	if(r1.right!=null && r2.right!=null) {
        		if(r1.right.data!=r2.right.data)
        			return false;
        		else {
        			s1.push(r1.right);
        			s2.push(r2.right);
        		}
        	}else {
        		if((r1.right==null && r2.right!=null) || (r1.right!=null && r2.right==null))
        			return false;
        	}
        		
        }
        if(!s1.isEmpty() || !s2.isEmpty())
        	return false;
        return true;
    }
    
    public boolean isSymmetric(Node root) {
        if(root!=null) {
        	Stack<Node> s1 = new Stack<Node>();
        	Stack<Node> s2 = new Stack<Node>();
        	if(root.left!=null && root.right!=null && root.left.data == root.right.data) {
        		s1.add(root.left);
        		s2.add(root.right);
        		while(!s1.isEmpty() && !s2.isEmpty()) {
        			Node r1 = s1.pop();
        			Node r2 = s2.pop();
        			if(r1.data != r2.data)
        				return false;
        			if(r1.left!=null && r2.left!=null) {
        				s1.push(r1.left);
        				s2.push(r2.left);
        			}else {
        				return false;
        			}
        			if(r1.right!=null && r2.right!=null) {
        				s1.push(r1.right);
        				s2.push(r2.right);
        			}else {
        				return false;
        			}
        		}
        	}else {
        		return false;
        	}
        	if(s1.isEmpty() && s2.isEmpty())
        		return true;
        	return false;
        }
        return false;
    }
    
    public List<List<Integer>> levelOrder(Node root) {
    	if(root!=null) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> inner = new ArrayList<Integer>();
    	Queue<Node> q = new LinkedList();
    	q.add(root);
    	int counter1=1,counter2 =0;
    	
    	while(!q.isEmpty()) {
    		Node r = q.poll();
    		inner.add(r.data);
    		
    		if(r.left!=null) {
    			q.add(r.left);
    			counter2++;
    		}
    			
    		if(r.right!=null) {
    			q.add(r.right);
    			counter2++;
    		}
    		if(--counter1 == 0) {
    			//System.out.println("\n");
    			list.add(inner);
    			inner = new ArrayList<Integer>();
    			counter1 = counter2;
    			counter2 =0;
    		}
    			
    	}
    	return list;
    	}
		return new ArrayList<List<Integer>>();
    }
    
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntBST bst = new IntBST();
//		int[] a = {5,3,6,2,4,7};
//		for(int i:a) {
//			bst.insert(i);
//		}
//		bst.levelOrderTraversal();
//		System.out.println("\n");
//		System.out.println(bst.findTarget(bst.root, 9));
//		int[] a1 = {1,2};
//		for(int i:a1) {
//			bst.insert(i);
//		}
////		bst.levelOrderTraversal();
//		int[] res = bst.findMode(bst.root);
//		System.out.println("Most Frequently occuring Node\n");
//		if(res!=null) {
//			for(int i:res) {
//				System.out.print(i+ " ");
//			}
//		}
		
//		int[] a = {3,9,20,15};
//		for(int i:a) {
//			bst.insert(i);
//		}
//		bst.levelOrderTraversal();
////		List<Double> l = bst.averageOfLevels(bst.root);
////		Iterator it = l.iterator();
////		while(it.hasNext()) {
////			System.out.print(it.next() + " ");
////		}
//		
//		//System.out.println(bst.sumOfLeftLeaves(bst.root));
		IntBST bst2 = new IntBST();
		int[] a1 = {3,9,20,15,7};
		for(int i:a1) {
			bst2.insert(i);
		}
		//bst2.levelOrderTraversal();
//		System.out.println(bst.isSameTree(bst.root, bst2.root));
		
		List<List<Integer>> l = bst2.levelOrder(bst2.root);
		Iterator it = l.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
