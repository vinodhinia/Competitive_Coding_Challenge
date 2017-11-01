import java.util.*;
public class Duplicates {

	public String removeDuplicateLetters(String s) {
        Set<Character> set = new LinkedHashSet<Character>();
        for(int i=0;i<s.length();i++) {
        	if(!set.contains(s.charAt(i))) {
        		set.add(s.charAt(i));
        	}
        }
        Iterator it = set.iterator();
        StringBuffer buff = new StringBuffer();
        while(it.hasNext()) {
        	buff.append(it.next());
        }
        char[] sarr = buff.toString().toCharArray();
        Arrays.sort(sarr);
//        System.out.println(sarr);
        return new String(sarr);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Duplicates d = new Duplicates();
		System.out.println(d.removeDuplicateLetters("cbacdcbc"));
		
	}

}
