import java.util.HashMap;
import java.util.Stack;

public class Ex {
	
	public int maxDifference(int[] a) {
	    int min = a[0];
	    int max = a[1] -a[0];
	    for(int i=1;i<a.length;i++){
	        int potential_max = a[i] - min;
	        min = Math.min(min, a[i]);
	        max = Math.max(max,potential_max);
	    }
	    return max;
	}
	
	
	static String[] braces(String[] values) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		String[] result = new String[values.length];
		
		Stack<Character> stack = new Stack<Character>();
		for(int i =0;i<values.length;i++) {
			String t = values[i];
			for(int j=0;j<t.length();j++) {
				
				if(map.containsKey(t.charAt(j))) {
					stack.push(t.charAt(j));
				}else {
					char ch = stack.peek();
					char val = map.get(ch);
					if(val != t.charAt(i)) {
						result[i] = "NO";
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.isEmpty())
				result[i] = "YES";
			else
				result[i] = "NO";
			stack = new Stack<Character>();
			result[i] = "YES";
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex e = new Ex();
		int[] n = {7,9,5,6,3,2};
		System.out.println(e.maxDifference(n));
		
		String[] s = {"{} [] ()" , "{[}]"};
		String [] sarr = e.braces(s);
		System.out.println(sarr[0]+" "+sarr[1]);

}
}
