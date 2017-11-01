import java.util.*;

public class MaxDepth {

	public TreeNode root;
	
	public int findMaxDepth(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList();
		q.offer(root);
		
		int count=-1;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- >0) {
				TreeNode t = q.poll();
				if(t.left!=null)
					q.offer(t.left);
				if(t.right!=null)
					q.offer(t.right);
			}
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDepth m = new MaxDepth();
		m.root = new TreeNode(1);
		m.root.left = new TreeNode(2);
		m.root.right = new TreeNode(3);
		m.root.left.left = new TreeNode(4);
		m.root.left.right = new TreeNode(5);
		
		m.root.right.right = new TreeNode(6);
		m.root.right.right.right = new TreeNode(7);
		System.out.println(m.findMaxDepth(m.root));
	}

}
