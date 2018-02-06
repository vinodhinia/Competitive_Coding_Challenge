
public class Bus extends Vechicle{
	
	public Bus(){
		
		spotsNeeded = 5;
		size = VechicleSize.LARGE;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}

}
