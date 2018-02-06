import java.util.*;

public class Solution {
	
	public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, List<Character>> colCheck = new HashMap<Integer, List<Character>>();
        HashMap<Integer, List<Character>> rowCheck = new HashMap<Integer, List<Character>>();
        for(int row= 0;row< board.length;row ++) {
        		List<Character> rowlist = new ArrayList<Character>();
        		for(int col=0;col < board[row].length;col++) {
        			if(board[row][col] == '.')
        				continue;
        			//Row Check
        			if(rowlist.size() > 0 && rowlist.contains(board[row][col]))
        				return false;
        			else {
        				rowlist.add(board[row][col]);
        				rowCheck.put(row, rowlist);
        			}
        			//Column Check
        			if(colCheck.containsKey(col)) {
        				List<Character> l = colCheck.get(col);
            			if(l.contains(board[row][col]))
            				return false;
            			else {
            				l.add(board[row][col]);
            				colCheck.put(col, l);
            			}
        			}else {
        				List<Character> l = new ArrayList<Character>();
        				l.add(board[row][col]);
        				colCheck.put(col, l);
        			}
        			
        				
        		}
        }
        
        for(int row = 3;row<= 5;row++) {
            HashSet<Character> cube = new HashSet<Character>();

        	for(int col = 3;col<=5;col++) {
        		if(board[row][col] != '.' && !cube.add(board[row][col])) {
        			return false;
        		}
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		char[][] board = {
				{'5','3' ,'.', '.','7','.', '.', '.', '.'},
				{'6', '.', '.','1','9','5', '.', '.', '.'},
				{'.', '9', '8','.', '.', '.','.', '6', '.'},
				{'8', '.', '.','.', '6', '.', '.','.','3'},
				{'4', '.', '.','8', '.', '3', '.','.','1'},
				{'7', '.', '.','.', '2', '.', '.','.','6'},
				{'.', '6', '.','.', '.', '.', '2','8','.'},
				{'.', '.', '.','4', '1', '9', '.','.','.'},
				{'.', '.', '.','.', '8', '.', '.','7','9'}
		};
		
		String[][] board1 = {
				{"7",".",".",".","4",".",".",".","."},
				{".",".",".","8","6","5",".",".","."},
				{".","1",".","2",".",".",".",".","."},
				{".",".",".",".",".","9",".",".","."},
				{".",".",".",".","5",".","5",".","."},
				{".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".","2",".","."},
				{".",".",".",".",".",".",".",".","."},
				{".",".",".",".",".",".",".",".","."}
		};
		System.out.println(s.isValidSudoku(board));
		String[][] board2 = {
				{".",".",".",".","5",".",".","1","."},
				{".","4",".","3",".",".",".",".","."},
				{".",".",".",".",".","3",".",".","1"},
				{"8",".",".",".",".",".",".","2","."},
				{".",".","2",".","7",".",".",".","."},
				{".","1","5",".",".",".",".",".","."},
				{".",".",".",".",".","2",".",".","."},
				{".","2",".","9",".",".",".",".","."},
				{".",".","4",".",".",".",".",".","."}
		};
	
		
	}
		}
	


