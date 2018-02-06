
public class Rotate2DMatrix {
	
	int[][] matrix;
	
	Rotate2DMatrix(int[][] matrix){
		this.matrix = matrix;
	}
	
	public void transpose() {
		for(int r =0;r<matrix.length;r++) {
			for(int c=r;c<matrix[r].length;c++) {
				int temp = matrix[r][c];
				matrix[r][c] = matrix[c][r];
				matrix[c][r] = temp;
			}
		}
	}
	
	//{1,5,9,13}
//	  {2,6,10,14} 
//	  {3,7,11,15}
//	  {4,8,12,16}
	
	public void swap() {
		for(int r=0;r<matrix.length;r++) {
			int l=0, right =matrix[r].length-1;
			while(l<=right) {
				int temp = matrix[r][l];
				matrix[r][l] = matrix[r][right];
				matrix[r][right] = temp;
				l++;
				right--;
			}
		}
	}
	
	public void printLn() {
		for(int r =0;r<matrix.length;r++) {
			for(int c=0;c<matrix[r].length;c++) {
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		Rotate2DMatrix r  = new Rotate2DMatrix(matrix);
		r.transpose();
		r.swap();
		r.printLn();
		
//		output = {
//		{13, 9, 5, 1},
//		{14, 10, 6, 2},
//		{15, 11, 7, 3},
//		{16, 12, 8, 4},
//		}
		}
	}


