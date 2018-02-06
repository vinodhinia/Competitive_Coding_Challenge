import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val){
		this.val = val;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	
	public static List<Integer> preorderTraversal(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode r = stack.pop();
			list.add(r.val);
			
			if(r.right != null)
				stack.push(r.right);
			if(r.left != null) {
				stack.push(r.left);
			}
					
		}
		return list;
	}
	
	public static ArrayList<Integer> inOrderTraversal(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		TreeNode node = root;
		while(node!=null || !stack.isEmpty()) {
			while(node!=null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			list.add(node.val);
			node = node.right;
		}
		return list;
	}
	
	public static List<Integer> postorderTraversal(TreeNode root){
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		List<Integer> list = new ArrayList<Integer>();
		stack1.add(root);
		
		while(!stack1.isEmpty()) {
			TreeNode r = stack1.pop();
			stack2.push(r);
			
			if(r.left !=null)
				stack1.push(r.left);
			if(r.right!=null)
				stack1.push(r.right);
		}
		while(!stack2.isEmpty()) {
			list.add(stack2.pop().val);
		}
		return list;
	}
	
	public static void printLn(List<Integer> list) {
		for(Integer l : list) {
			System.out.print(l + " ");
		}
		System.out.println();
	}
	
	
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        stack1.push(A);
        while(!stack1.isEmpty()){
            TreeNode r = stack1.pop();
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(r.val);
            System.out.print(r.val+ " ");
            res.add(l);
            
            if(r.left != null)
                stack2.push(r.left);
            if(r.right != null)
                stack2.push(r.right);
            ArrayList<Integer> l1 = new ArrayList<Integer>();
            while(!stack2.isEmpty()){
                TreeNode n = stack2.pop();
                System.out.print(n.val+ " ");
                l1.add(n.val);
                
                if(n.right != null)
                    stack1.push(n.right);
                if(n.left != null)
                    stack1.push(n.left);
            }
            res.add(l1);
            
        }
        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(18);
		
		List<Integer> preOrder = preorderTraversal(root);
		List<Integer> inOrder = inOrderTraversal(root);
		List<Integer> postOrder = postorderTraversal(root);
		
		System.out.println("PreOrder Traversal");
		printLn(preOrder);
		System.out.println("InOrder Traversal");
		printLn(inOrder);
		System.out.println("PostOrder Traversal");
		printLn(postOrder);
		
		System.out.println("Zig Zak Traversal");
		ArrayList<ArrayList<Integer>> res = zigzagLevelOrder(root);
//		for(ArrayList<Integer> list : res) {
//			for(Integer i : list) {
//				System.out.print(i +" ");
//			}
//			System.out.println();
//		}
	}

}
