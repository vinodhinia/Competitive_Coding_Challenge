
public class Solution {
	
	public static int[][] transpose(int[][] matrix) {
		for(int col=0;col<matrix[0].length;col++) {
 			for(int row=col;row<matrix.length;row++) {
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
		return matrix;
	}
	
	public static int[][]  swap(int[][] matrix) {
		for(int row =0;row<matrix.length;row++) {
			int start = 0, end = matrix[0].length-1;
			while(start<=end) {
				int temp = matrix[row][start];
				matrix[row][start] = matrix[row][end];
				matrix[row][end] = temp;
				start++;
				end--;
			}
		}
		return matrix;
	}
	
	public static void rotateArr(int[][] matrix) {
		System.out.println("Array before rotation");
		printLn(matrix);
		matrix = transpose(matrix);
		System.out.println("Transpose of Array");
		printLn(matrix);
		matrix = swap(matrix);
		
		System.out.println("Array after rotation");
		printLn(matrix);
	}
	
	public static void rotate(int[][] matrix) {
		int r = 0, c = matrix[0].length-1;
		int[][] m = new int[matrix.length][matrix[0].length];
		
		for(int row =0;row<matrix.length;row++) {
			for(int col =0;col<matrix[0].length;col++) {
				m[r++][c] = matrix[row][col];
			}
			r = 0;
			c--;
		}
		System.out.println("Array before rotation");
		printLn(matrix);
		System.out.println("Array after rotation");
		printLn(m);
		
	}
	
	public static void printLn(int[][] arr) {
		for(int r = 0;r<arr.length;r++) {
			for(int c=0;c<arr[0].length;c++) {
				System.out.print(arr[r][c] +" ");
			}
			System.out.println();
		}
	}
	
	public static void rotateImage(int[][] matrix) {
		int N = matrix.length;
		for(int x = 0;x<N; x++) {
			for(int y = x ;y< N-x-1;y++) {
				
				int temp = matrix[x][y];
				matrix[x][y] = matrix[N-x-1][y];
				matrix[N-x-1][y] = matrix[N-x-1][N-y-1];
				matrix[N-x-1][N-y-1] = matrix[N-y-1][x];
				matrix[N-y-1][x] = temp;
				
			}
		}
		
		int n = matrix.length;
		for(int x=0;x<matrix.length/2;x++) {
			int first = x;
			int last = n-1-x;
			for(int y=first;y<last;y++) {
				int offset = y-first;
				int top = matrix[first][y];
				matrix[first][y] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[y][last];
				matrix[y][last] = top;
			}
		}
		
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				 {1, 2 ,3},
				 {4, 5 ,6},
				 {7, 8 ,9}
		};
		//rotateImage(matrix);
		rotateArr(matrix);
	}

}
