import java.util.*;

class TreeNode 
{
    int data;
    TreeNode left, right;
  
    TreeNode(int item) 
    {
        data = item;
        left = right = null;
    }
}
public class Solution {
	TreeNode root;
	

	public void printPath(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		printPathHelper(root, list);
	}
	
	public void printPathHelper(TreeNode node, List<Integer> list) {
		if(node == null)
			return;
		list.add(node.data);
		
		if(node.left == null && node.right == null)
			printLn(list);
		else {
			printPathHelper(node.left, list);
			printPathHelper(node.right, list);
		}
	}
	
	public void printLn(List<Integer> l) {
		for(Integer i : l) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Solution tree = new Solution();
		  
	        tree.root = new TreeNode(1);
	        tree.root.left = new TreeNode(2);
	        tree.root.right = new TreeNode(3);
	        tree.root.left.left = new TreeNode(4);
	        tree.root.left.right = new TreeNode(5);
	  
	        /* Print all root-to-leaf paths of the input tree */
	        tree.printPath(tree.root);
	}

}
