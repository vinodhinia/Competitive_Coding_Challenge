
public class ReverseVowels {

	public String reverseVowels(String s) {
		char[] ch = s.toCharArray();
		
        int i=0, j=s.length()-1;
        while(i<j) {
        	if(isVowel(s.charAt(i))) {
        		if(isVowel(s.charAt(j))) {
        			ch = swap(ch,i,j);
        			j--;
        			i++;
        		}else {
        			j--;
        		}
        	}else if(isVowel(s.charAt(j)) && !isVowel(s.charAt(i))){
        		i++;
        	}else {
        		i++;
        		j--;
        	}
        }
        
        return new String(ch);
    }
	
	public char[] swap(char[] ch,int i,int j ) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return ch;
	}
	
	public boolean isVowel(char c) {
		if(c=='a' || c=='e' || c=='i'|| c=='o' || c=='u' || c=='A' || c=='E'||c=='I'||c=='O'||c=='U') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseVowels r = new ReverseVowels();
		System.out.println(r.reverseVowels("leetcode"));
	}

}
