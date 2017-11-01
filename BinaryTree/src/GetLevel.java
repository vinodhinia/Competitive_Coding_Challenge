import java.util.*;
public class GetLevel {
	
	public TreeNode root;
	
	public int[] getLevel(TreeNode root, int level) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		List<Integer> l = new ArrayList<Integer>();
		
		int count =-1;
		while(!q.isEmpty()) {
			int size = q.size();
			
			if(count+1 == level) {
				while(size--!=0) {
					l.add(q.poll().val);
				}
				break;
			}
			while(size-- > 0) {
				TreeNode r = q.poll();
				if(r.left!=null)
					q.offer(r.left);
				if(r.right!=null)
					q.offer(r.right);
			}
			count++;
		}
		
		int[] res = new int[l.size()];
		Iterator<Integer> it = l.iterator();
		int i=0;
		while(it.hasNext()) {
			res[i++] = it.next();
		}
		return res;
	}

	public static void main(String[] args) {
		GetLevel g = new GetLevel();
		g.root = new TreeNode(1);
		g.root.left = new TreeNode(2);
		g.root.right = new TreeNode(3);
		g.root.left.left = new TreeNode(4);
		g.root.left.right = new TreeNode(5);
		
		g.root.right.right = new TreeNode(6);
		g.root.right.right.right = new TreeNode(7);
		
		
		int[] r = g.getLevel(g.root, 2);
		for(int i: r)
			System.out.println(i);;
	}
}
