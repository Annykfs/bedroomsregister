package model;

public class Conversor {
	
public String toString(int valueInt) {
		
		String valueString = Integer.toString(valueInt);
		
		return valueString;
	}
	
	public int toInt(String valueString) {
		
		int valueInt = Integer.parseInt(valueString);
		
		return valueInt;
	}
	
	public float toFloat(String valueString) {
		
		float valueFloat = Float.parseFloat(valueString);
		
		return valueFloat;
	}
	
	public String toStringF(float valueFloat) {
		
		String valueStringF = Float.toString(valueFloat);
		
		return valueStringF;
	}
}
