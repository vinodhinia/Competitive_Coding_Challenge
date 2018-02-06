import java.util.*;

public abstract class Vechicle {
	public final int id;
	public String vechicleType;
	protected String licensePlate;
	public final int spotsNeeded;
	private final double costFactor;
	protected VechicleSize size;
	
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	
	
	Vechicle(int id, String vechicleType, int spotsNeeded, double costFactor){
		this.id = id;
		this.vechicleType = vechicleType;
		this.spotsNeeded = spotsNeeded;
		this.costFactor = costFactor;
	}
	
	public int getSpotsNeeded() { 
		return spotsNeeded; 
	}
	
//	 Park vehicle in this spot (among others, potentially) 
	public void parkInSpot(ParkingSpot s) { 
		parkingSpots.add(s); 
	}

	public void clearSpots() {
		
	}
	
	public abstract boolean canFitInSpot(ParkingSpot spot);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
