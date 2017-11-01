import java.util.*;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x){
		val = x;
		left = null;
		right = null;
	}
}

public class PreOrder {
	Stack<TreeNode> s = new Stack<TreeNode>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
	        if(root!=null) {
	        s.add(root);
	        while(!s.isEmpty()) {
	        	TreeNode r = s.pop();
	        	list.add(r.val);
	        	if(r.right!=null) {
	        		s.push(r.right);
	        	}
	        	if(r.left!=null)
	        		s.push(r.left);
	        }
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
