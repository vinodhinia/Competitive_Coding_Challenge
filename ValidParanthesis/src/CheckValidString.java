import java.util.*;
public class CheckValidString {
	
	public boolean checkValidString(String s) {
       Stack<Integer> para = new Stack<Integer>();
       Stack<Integer> star = new Stack<Integer>();
       
       for(int i=0;i<s.length();i++) {
    	   if(s.charAt(i) == '(')
    		   para.push(i);
    	   else if(s.charAt(i) == '*')
    		   star.push(i);
    	   else {
    		   if(!para.isEmpty())
    			   para.pop();
    		   else if(!star.isEmpty())
    			   star.pop();
    		   else
    			   return false;
    	   }
       }
       while(!para.isEmpty() && !star.isEmpty()) {
    	   if(para.pop() < star.pop()) {
        		return true;
        	}
    	   return false;
       	}
       
       return para.isEmpty();
       
    }
	
	
	 static public int lengthOfLastWord(String s) {
	        if(s == "")
	            return 0;
	        if(s.length() >= 1){
	        	if(s.matches("[a-zA-z0-9]*")) {
	        		String[] sarr = s.split(" ");
		            return sarr[sarr.length-1].length();
	        	}
	            
	        }
			return 0;
	        
	    }
	
	
	
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckValidString c = new CheckValidString();
//		String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
//		System.out.println(c.checkValidString(s));
//		System.out.println(c.decimatToBinary(6));
//		
//		String binary = c.decimatToBinary(6);
//		System.out.println(c.countConsecutive1(binary));
		
		String s = " a";
		System.out.println(lengthOfLastWord(s));
		
	}

}
