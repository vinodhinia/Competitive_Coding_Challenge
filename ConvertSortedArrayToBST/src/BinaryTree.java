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
	
	public TreeNode sortedArrayToBST(int[] nums) {
	     return sortedArrayToBSTHelper(nums, 0, nums.length-1);
	}
	
	public TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
		if(start > end)
			return null;
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBSTHelper(nums, start, mid-1);
		node.right = sortedArrayToBSTHelper(nums, mid+1, end);
		return node;
	}
	
	public void printTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList();
		q.offer(root);
		int counter1 = 1, counter2 = 0;
		while(!q.isEmpty()) {
			while(counter1-- > 0) {
				TreeNode r = q.poll();
				System.out.print(r.val+" ");
				if(r.left!=null) {
					q.offer(r.left);
					counter2++;
				}
				if(r.right !=null) {
					q.offer(r.right);
					counter2++;
				}
			}
			if(counter1 == 0) {
				counter1 = counter2;
				counter2 = 0;
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		// TODO Auto-generated method stub
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = b.sortedArrayToBST(nums);
		b.printTree(root);
		
		
	}

}
