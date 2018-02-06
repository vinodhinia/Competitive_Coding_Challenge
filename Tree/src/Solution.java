import java.util.*; 

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
public class Solution {
	
	
    public int isSymmetric1(TreeNode A) {
        return isSymmetricHelper1(A , A);
    }
    
    public int isSymmetricHelper1(TreeNode t1, TreeNode t2){
        if(t1!=null && t2!=null && t1.val == t2.val)
            return 1;
        if(t1!=null && t2!=null && t1.val != t2.val)
            return 0;
        
        if(isSymmetricHelper1(t1.left, t2.right) == 1 && isSymmetricHelper1(t1.right, t2.left) == 1)
            return 1;
        return 0;
    }
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeHelper(p, q);
    }
    
    public boolean isSameTreeHelper(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p == null && q!=null || p!=null && q==null){
            return false;
        }
        if(p.val!=q.val)
            return false;
        
        return isSameTreeHelper(p.left, q.left) && isSameTreeHelper(p.right, q.right);
    }
    
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<Integer>();
        inorder(root,l);
        return l.get(k+1);
        
    }
    
    public void inorder(TreeNode node, List<Integer> list){
        if(node!=null){
            inorder(node.left, list);
            list.add(node.val);
            inorder(node.right,list);
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }
    
    public boolean isSymmetricHelper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1.val != node2.val )
            return false;
        if((node1 != null && node2 == null) || (node1 == null && node2 != null))
            return false;
        return isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
    }
    
    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = A;
        
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
            
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		List<Integer> l = inorderTraversal(root);
		System.out.println(l.size());
		for(Integer i: l)
			System.out.println(i);
	}

}
