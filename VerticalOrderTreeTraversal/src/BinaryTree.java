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
	
	public static TreeMap<Integer, List<Integer>> getVerticalOrder(TreeNode node, int distance,TreeMap<Integer, List<Integer>> map){
		if(node == null)
			return null;
		List<Integer> list = map.get(distance);
		if(list == null) {
			list = new ArrayList<Integer>();
			list.add(node.val);
		}else {
			list.add(node.val);
		}
		map.put(distance, list);
		getVerticalOrder(node.left, distance-1, map);
		getVerticalOrder(node.right, distance+1, map);
		return map;
	}
	
	public static List<List<Integer>> verticalOrderTraversal(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
		getVerticalOrder(root, 0, map);
		for(Map.Entry<Integer, List<Integer>> m : map.entrySet()) {
			res.add(m.getValue());
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(18);
		List<List<Integer>> res = verticalOrderTraversal(root);
		for(List<Integer> list: res) {
			for(Integer i: list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}

}
