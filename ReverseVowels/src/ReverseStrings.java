
public class ReverseStrings {
	
	public String reverseString(String s) {
        char[] ch = s.toCharArray();
        int i=0,j=ch.length-1;
        while(i<j) {
        	char temp = ch[i];
        	ch[i] = ch[j];
        	ch[j] = temp;
        	i++;
        	j--;
        }
        return new String(ch);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseStrings r = new ReverseStrings();
		System.out.println(r.reverseString("hello"));
	}

}
