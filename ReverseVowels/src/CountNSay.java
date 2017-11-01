import java.util.*;
public class CountNSay {
	
	public String countAndSay(int n) {
		String s = "1";
		if(n==1)
			return "1";
		if(n==2)
			return "11";
		
		int i=2;
		
		s = "11";
		while(i!=n) {
			StringBuffer buff = new StringBuffer();
			int count = 1;
			for(int j=1;j<s.length();j++) {
				if(s.charAt(j) == s.charAt(j-1)) {
					count++;
				}else {
					buff.append(count);
					buff.append(s.charAt(j-1));
					count = 1;
					
				}
			}
			buff.append(count);
			buff.append(s.charAt(s.length()-1));
//			count = 1;
			i++;
			s = buff.toString();
		}
		return s;			
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountNSay c = new CountNSay();
		System.out.println(c.countAndSay(5));
	}

}
