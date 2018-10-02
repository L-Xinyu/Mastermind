package utils;

public class MaxLength {
	private int max;
	
	public MaxLength(int max) {
		this.max = max;
	}
		
	public boolean includes(int value) {
		return value == max;
	}

	@Override
	public String toString() {
		return ""+ max + "";
		
	}

}
