package MySolution;
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
class Solution {
    
    List<TreeNode> path1 = new ArrayList<TreeNode>();
    List<TreeNode> path2 = new ArrayList<TreeNode>();
    
    public boolean findPath(TreeNode node, List<TreeNode> path, int n){
        if(node == null)
            return false;
        path.add(node);
        
        if(node.val == n)
            return true;
        
        if(node.left != null && findPath(node, path, n))
            return true;
        if(node.right!= null && findPath(node, path, n))
            return true;
        path.remove(path.size()-1);
        return false;
        
    }
    
    public TreeNode lowestCommonAncestorHelper(TreeNode node, TreeNode p, TreeNode q){
        path1.clear();
        path2.clear();
        
        if(!findPath(node, path1, p.val) || !findPath(node, path2, q.val))
            return null;
        int i=0;
        for(i=0;i< path1.size() && i< path2.size();i++){
            if(path1.get(i).val != path2.get(i).val)
                break;
        }
        return path1.get(i-1);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return lowestCommonAncestorHelper(root, p, q);
        
    }
}
