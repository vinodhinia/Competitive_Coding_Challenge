package interface_segregation_principle.bad;

public class Eagle implements Bird{
	int numOfFeathers;
	

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("It can fly high");
	}

	@Override
	public void mold() {
		// TODO Auto-generated method stub
		System.out.println(this.numOfFeathers -1); 
		
	}

}
