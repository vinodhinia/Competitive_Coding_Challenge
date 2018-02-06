public class Solution {
	
	
	public void dfs(char[][] grid, int r, int c) {
		if(r<0 || c<0 || r > grid.length || c > grid[0].length || grid[r][c] == '0')
			return;
		grid[r][c] = '0';
		
		dfs(grid, r+1, c);
		dfs(grid, r-1, c );
		dfs(grid, r, c+1);
		dfs(grid, r, c-1);

		
	}
	
	public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int numberOfIslands = 0;
        
        for(int r=0; r<nr; r++) {
        		for(int c =0;c<nc; c++) {
        			if(grid[r][c] == '1') {
        				numberOfIslands++;
        				dfs(grid, r, c);
        			}
        		}
        }
        
        return numberOfIslands;
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
			
			};
		System.out.println(s.numIslands(grid));
		}
	}


