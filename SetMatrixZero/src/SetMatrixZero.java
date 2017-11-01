
public class SetMatrixZero {
	
	public int[][] setZero(int[][] matrix){
		boolean[] rows = new boolean[matrix.length];
		boolean[] cols = new boolean[matrix[0].length];
		
		for(int row = 0; row <matrix.length;row++) {
			for(int col=0;col<matrix[row].length;col++) {
				if(matrix[row][col] == 0) {
					rows[row] = true;
					cols[col] = true;
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				if(rows[i]==true || cols[j] == true) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetMatrixZero m = new SetMatrixZero();
		int[][] matrix = {
				{1 , 1, 1},
				{0, 1, 1},
				{1, 1, 0}
		};
		
		int[][] res = m.setZero(matrix);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j] + " ");
				
			}
			System.out.println("\n");
		}

	}

}
