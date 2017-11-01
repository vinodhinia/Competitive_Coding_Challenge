import java.util.*;

public class ValidParanthesis {
		HashMap<Character, Character>  map = new HashMap<Character,Character>();
		
		public void constructMap() {
			map.put('(',')');
			map.put('[',']');
			map.put('{','}');
		}
		
		public boolean isValid(String str) {
			constructMap();
			Stack<Character> stack = new Stack<Character>();
			if(str.length() == 1)
				return false;
			
			for(int i=0;i<str.length();i++) {
//				System.out.println(str.charAt(i));
				if(map.containsKey(str.charAt(i))) {
					stack.push(str.charAt(i));
				}else if(!stack.isEmpty()){
					if(map.get(stack.peek()) != str.charAt(i)) {
						return false;
					}else {
						stack.pop();
					}
				}else {
					return false;
				}
			}
			if(!stack.isEmpty()) {
				return false;
			}
			return true;
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParanthesis v = new ValidParanthesis();
		System.out.println(v.isValid("){"));
		
	}

}
