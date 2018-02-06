import java.util.*;

public class Solution {
	
	public static String[] findWords(String[] words) {
		String[] res = new String[0];
		if(words.length < 1)
			return res;
        List<String> result = new ArrayList<String>();
        
        List<String> checklist = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        list.add("qwertyuiop");
        list.add("asdfghjkl");
        list.add("zxbcvnm");
        
        for(String s : words){
                char c = s.charAt(0);
                c = Character.toLowerCase(c);
                if(list.get(0).indexOf(c)!=-1){
                    checklist = new ArrayList<String>();
                    checklist.add(list.get(0));
                }else if(list.get(1).indexOf(c)!=-1){
	                	checklist = new ArrayList<String>();
	                 checklist.add(list.get(1));
                }else{
                    checklist  = new ArrayList<String>();
                    checklist.add(list.get(2));
                }
             int i;
            for( i=0;i<s.length();i++){
            	   char ch = s.charAt(i);
                ch = Character.toLowerCase(ch);
                if(checklist.get(0).indexOf(ch)==-1){
                    break;
                }
                
            }
            if(i == s.length()){
                result.add(s);
            }
            
        }
        res = new String[result.size()];
        int k=0;
        for(String r: result){
            res[k++] = r;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] arr = {"Hello", "Alaska", "Dad", "Peace"};
		String[] arr = {"a", "b"};
		String[] r = findWords(arr);
		for(String s :  r) {
			System.out.println(s);
		}
	}

}
