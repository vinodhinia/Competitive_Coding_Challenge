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

public class InOrder {
	Stack<TreeNode> s = new Stack<TreeNode>();
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
        if(root!=null) {
        	s.add(root);
        	do {
        	
        		
        	}while(!s.isEmpty());
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
