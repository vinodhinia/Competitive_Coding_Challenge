
public class Solution {
	
	public String reverseWords(String a) {
		String[] sarr = a.split(" ");
		StringBuffer buff = new StringBuffer();
		
		for(String s: sarr) {
			if(!s.isEmpty()) {
				System.out.println(s);

				buff.append(reverseStr(s, 0, s.length()-1));
				buff.append(" ");
			}
		}
		
		return reverseStr(buff.toString(), 0, buff.toString().length()-1).trim();
	}
	
	public String reverseStr(String str, int start, int end) {
		char[] carr = str.toCharArray();
		
		while(start <= end) {
			char temp = carr[start];
			carr[start] = carr[end];
			carr[end] = temp;
			start++;
			end--;
		}
		return new String(carr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution  s = new Solution();
		String str = "   a   b ";
		System.out.println(s.reverseWords(str));
	}

}
