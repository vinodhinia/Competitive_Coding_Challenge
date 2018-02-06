import java.util.*;

public class Solution {
	
	public int trap(int[] heights) {
		int ans = 0, currentIndex = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(currentIndex <heights.length) {
			while(!stack.isEmpty() && heights[currentIndex] > heights[stack.peek()]) {
				int top = stack.pop();
				
				if(stack.isEmpty())
					break;
				
				int distance = currentIndex - stack.peek() - 1;
				int boundedHeight = Math.min(heights[currentIndex], heights[stack.peek()]) - heights[top];
				ans += distance * boundedHeight;
			}
			stack.push(currentIndex++);
		}
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
