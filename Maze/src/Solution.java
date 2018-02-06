
public class Solution {

	public int countPaths(int[][] maze) {
		return countPathHelper(maze, 0, 0, 0);
	}
	
	public int countPathHelper(int[][] maze, int r, int c, int count) {
		if(r > maze.length-1 || c > maze[0].length-1 || maze[r][c] == -1)
			return 0;
		
		if(r==maze.length-1 && c == maze[0].length-1)
			return count+1;
		return countPathHelper(maze, r+1, c, count) + countPathHelper(maze, r, c+1, count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = {{0,  0, 0, 0},
                			{0, -1, 0, 0},
                			{-1, 0, 0, 0},
                			{0,  0, 0, 0}};
		
		Solution s = new Solution();
		System.out.println(s.countPaths(maze));
				
	}

}
