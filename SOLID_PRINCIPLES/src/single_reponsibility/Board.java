package single_reponsibility;

import java.util.ArrayList;

public class Board {

	int size;
	public ArrayList<String> slots;
	
	public Board(int size) {
		this.size = size;
		this.slots = new ArrayList<String>(size);
		
		for(int i=0;i<size;i++) {
			this.slots.add(String.valueOf(3*i));
			this.slots.add(String.valueOf(3*i + 1));
			this.slots.add(String.valueOf(3*i + 2));
		}
	}
	
	
	public ArrayList<String> valuesAt(ArrayList<Integer> indexs){
		ArrayList<String> values = new ArrayList<String>();
		
		for(Integer index : indexs) {
			values.add(this.slots.get(index));
		}
		return values;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
