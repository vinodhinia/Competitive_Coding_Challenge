
public class KMP {
	
	public int[] computeLPS(char[] pattern) {int [] lps = new int[pattern.length];
    int index =0;
    for(int i=1; i < pattern.length;){
        if(pattern[i] == pattern[index]){
            lps[i] = index + 1;
            index++;
            i++;
        }else{
            if(index != 0){
                index = lps[index-1];
            }else{
                lps[i] =0;
                i++;
            }
        }
    }
    return lps;
    }
	
	public boolean kmp(char[] text, char[] pattern) {
		int[] lps =  computeLPS(pattern);
		int i=0,j=0;
		while(i<text.length && j<pattern.length) {
			if(text[i] == pattern[j]) {
				i++;j++;
			}else {
				if(j!=0) {
					j = lps[j-1];
				}else {
					i++;
				}
			}
		}
		System.out.println(i-pattern.length);
		if(j == pattern.length) {
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMP kmp = new KMP();
		String pattern = "aabaabaaa";
		int[] r = kmp.computeLPS(pattern.toCharArray());
		for(int i: r) {
			System.out.print(i+" ");
		}
		
		String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        
        System.out.println("Pattern Matching");
        System.out.println(kmp.kmp(str.toCharArray(), subString.toCharArray()));
	}

}
