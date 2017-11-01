
public class ReverseStr {
	
	public String reverseStr(String s, int k) {
        char[] cArr = s.toCharArray();
        if(s.length() < k) {
        	k = s.length();
        }
        int i=0,j=k-1;
        while(i<j) {
        	char temp = cArr[i];
        	cArr[i] = cArr[j];
        	cArr[j] = temp;
        	i++;
        	j--;
        }
        return new String(cArr);
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefg";
		int k = 2;
		ReverseStr r = new ReverseStr();
		System.out.println(r.reverseStr(s, k));
	}

}
