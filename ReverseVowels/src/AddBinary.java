import java.util.*;
public class AddBinary {

	public void addBinary(String a, String b) {
		if(a.length()<b.length()) {
        	a = padd(a, b.length()-a.length());
        }else {
        	b = padd(b,a.length()-b.length());
        }
		String c="";
		char carry='\0';
        int i=a.length()-1;
        while(i>=0) {
        	if(a.charAt(i)!=b.charAt(i)) {
            	if(a.charAt(i)=='1' ||b.charAt(i)=='1' && carry!='\0') {
            		c = '1'+ c;
            		carry = '1';
            	}
            }else {
            	if(a.charAt(i)=='1' ) {
            		c = '0'+c;
            		carry='1';
            	}else {
            		c +='0';
            		carry = '\0';
            	}
            }
        	i--;
        }
        if(carry!='\0') {
        	c = '1' + c;
        }
        System.out.println(c);
        
    }
	
	public String padd(String s,int len) {
		while(len!=0) {
			s = '0'+s;
			len--;
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary ab = new AddBinary();
		String a = "1111",b = "1";
		ab.addBinary(a, b);
	}

}
