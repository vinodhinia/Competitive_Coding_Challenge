import java.util.*;

public class Solution {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<String>(wordDict);
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visited = new int[s.length()];
		
		q.add(0);
		while(!q.isEmpty()) {
			int start = q.poll();
			if(visited[start] == 0) {
				for(int end = start+1;end<=s.length();end++) {
					if(set.contains(s.substring(start, end))) {
						q.add(end);
						if(end == s.length())
							return true;
					}
				}
			}
			visited[start] = 1;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="leetcode";
		List<String> list = new ArrayList<String>();
		list.add("lee");
		list.add("code");
		list.add("leet");
		Solution sol = new Solution();
		
		System.out.println(sol.wordBreak(s, list));
	}

}
