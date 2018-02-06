import java.util.*;

public class Solution {
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        while(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length){
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }
        
        return false;
    }
	
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    boolean[] row = new boolean[a.size()];
	    boolean[] col = new boolean[a.get(0).size()];
	    
	    for(int r = 0; r<a.size(); r++){
	        ArrayList<Integer> list = new ArrayList<Integer>(a.get(0));
	        for(int c = 0; c< list.size(); c++ ){
	            if( list.get(c) == 0){
	                row[r] = true;
	                col[c] = true;
	            }
	        }
	    }
	    
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    
	    for(int r = 0; r<a.size(); r++){
	        ArrayList<Integer> list = new ArrayList<Integer>(a.get(0));
	        for(int c = 0; c< list.size(); c++ ){
	        		if(row[r] == true || col[r] == true) {
	        			list.set(c, 0);
	        		}
	        }
	       res.add(list);
	    }
	    
	    for(ArrayList<Integer> outer : res) {
	    		for(Integer i :   outer) {
	    			System.out.print(i+ " ");
	    		}
	    		System.out.println();
	    }
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inner = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		inner.add(1);
		inner.add(0);
		inner.add(1);
		outer.add(inner);
		
		inner = new ArrayList<Integer>();
		inner.add(1);
		inner.add(1);
		inner.add(1);
		outer.add(inner);
		
		inner = new ArrayList<Integer>();
		inner.add(1);
		inner.add(1);
		inner.add(1);
		outer.add(inner);
		setZeroes(outer);
	}

}
