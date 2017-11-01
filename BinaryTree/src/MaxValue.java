import java.util.*;

public class MaxValue {
	public TreeNode root;

	public int findMaxValue(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int max = Integer.MIN_VALUE;
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode t = stack.pop();
			max = Math.max(t.val, max);
			if(t.left!=null) {
				stack.push(t.left);
			}
			if(t.right!=null) {
				stack.push(t.right);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxValue m = new MaxValue();
		m.root = new TreeNode(1);
		m.root.left = new TreeNode(2);
		m.root.right = new TreeNode(3);
		m.root.left.left = new TreeNode(4);
		m.root.left.right = new TreeNode(5);
		
		m.root.right.right = new TreeNode(6);
		m.root.right.right.right = new TreeNode(7);
		System.out.println(m.findMaxValue(m.root));
	}

}
