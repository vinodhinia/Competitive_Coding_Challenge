import java.util.*;

public class Solution {

	
	public static String replaceWords(List<String> dict, String sentence) {
        String[] sarr = sentence.split(" ");
        for(String d : dict){
            for(int i=0;i<sarr.length;i++){
                if(sarr[i].length() > d.length() && sarr[i].substring(0, d.length()).equals(d)){
                    sarr[i] = d;
                }
            }
        }
        sentence = "";
        for(String s: sarr){
            sentence += s +" ";
        }
        return sentence.trim();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[0];
		List<String> list = new ArrayList<String>();
		list.add("cat");
		list.add("bat");
		list.add("rat");
//		list.add("the");
		
		System.out.println(replaceWords(list, "the cattle was rattled by the battery\""));
	}

}
