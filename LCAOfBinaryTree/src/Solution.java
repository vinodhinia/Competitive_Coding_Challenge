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
public class Solution {
	
	TreeNode root;
	List<Integer> path1 = new ArrayList<Integer>();
	List<Integer> path2 = new ArrayList<Integer>();
	
	public boolean findPath(TreeNode node, int n, List<Integer> path) {
		if(node == null)
			return false;
		path.add(node.val);
		
		if(node.val == n)
			return true;
		
		if(node.left!=null && findPath(node.left, n, path ))
			return true;
		if(node.right!=null && findPath(node.right,n, path))
			return true;
		path.remove(path.size()-1);
		return false;
	}
	
	public int findLCAHelper(TreeNode node, int n1, int n2) {
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
		
		int i;
		for(i=0;i<path1.size() && i<path2.size();i++) {
			if(path1.get(i) != path2.get(i))
				break;
		}
		return path1.get(i-1);
		
	}
	
	public int findLCA(TreeNode root, int n1, int n2) {
		path1.clear();
		path2.clear();
		return findLCAHelper(root, n1,n2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution tree = new Solution();
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);
        System.out.println("LCA(4, 5): " + tree.findLCA(tree.root,4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(tree.root,4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(tree.root,3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(tree.root,2,4));
	}

}
