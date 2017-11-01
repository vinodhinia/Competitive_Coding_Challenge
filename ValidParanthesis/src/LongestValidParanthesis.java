import java.util.HashMap;
import java.util.Stack;

public class LongestValidParanthesis {
	HashMap<Character, Character>  map = new HashMap<Character,Character>();
	
	public void constructMap() {
		map.put('(',')');
	}

	 public int longestValidParentheses(String str) {
		 constructMap();
			Stack<Character> stack = new Stack<Character>();
			int counter=0,max = Integer.MIN_VALUE;
			if(str.length() <= 1)
			return 0;
			
			for(int i=0;i<str.length();i++) {
				if(map.containsKey(str.charAt(i))) {
					stack.push(str.charAt(i));
				}else if(!stack.isEmpty()) {
					if(map.get(stack.peek()) == str.charAt(i)) {
						stack.pop();
						if(stack.size() >= 1 && i>=str.length()-1) {
							counter = 2;
							if(max < counter) 
								max = counter;
						}else {
							counter+=2;
							if(max < counter) 
								max = counter;
						}
 						
					}else {
						counter = 0;
					}
				}else {
					
					if(max < counter) {
						max = counter;
						
					}
					counter = 0;
				}
			}
			return max;
	  }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidParanthesis l = new LongestValidParanthesis();
		System.out.println(l.longestValidParentheses("(()()"));
		
	}

}
