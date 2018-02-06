package interface_segregation_principle.bad;

public class Penguin implements Bird{
	int numberOfFeathers;
	
	Penguin(){
		numberOfFeathers = 1;
	}

	@Override
	public void fly() throws Exception {
		// TODO Auto-generated method stub
		throw new Exception("It cannotFly");
	}
	
	public static int bracket_match(String bracket_string) {
        int count=0;
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<bracket_string.length();i++){
            if(bracket_string.charAt(i) == '(')
                s.push(bracket_string.charAt(i));
            else{
                if(!s.isEmpty())
                    s.pop();
                else
                    count++;
            }
        }       
        return count + s.size();      
    }

	@Override
	public void mold() {
		// TODO Auto-generated method stub
		System.out.println(this.numberOfFeathers -1);
	}

}
