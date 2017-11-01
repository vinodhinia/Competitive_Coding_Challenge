import java.util.Stack;

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
public class CountLeaves {
	public TreeNode root;
	
	public int countLeaves(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		int count = 0;
		while(!stack.isEmpty()) {
			TreeNode t = stack.pop();
			if(t.left==null && t.right ==null) {
				count++;
			}
			if(t.left!=null) {
				stack.push(t.left);
			}
			if(t.right!=null) {
				stack.push(t.right);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountLeaves c = new CountLeaves();
		c.root = new TreeNode(1);
		c.root.left = new TreeNode(2);
		c.root.right = new TreeNode(3);
		c.root.left.left = new TreeNode(4);
		c.root.left.right = new TreeNode(5);
		
		c.root.right.right = new TreeNode(6);
		c.root.right.right.right = new TreeNode(7);
		
		System.out.println(c.countLeaves(c.root));
	}

}
