
public class ReverseString {
	
	
	public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuffer buff = new StringBuffer();
        
        for(int i=0;i<sArr.length;i++) {
        	String sTemp = sArr[i];
        	for(int j=sTemp.length()-1;j>=0;j--) {
        		buff.append(sTemp.charAt(j));
        	}
        	buff.append(" ");
        }
        buff.deleteCharAt(buff.length()-1);
        return buff.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString r = new ReverseString();
		System.out.println(r.reverseWords("Let's take LeetCode contest"));
			
	}

}
