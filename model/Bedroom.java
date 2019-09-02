package model;

public class Bedroom {
	
	private int id;
	String owner;
	float area;
	int number;
	String color;
	String suite;
	
	public Bedroom() {
		
	}
	public Bedroom(int id, String owner, float area, int number, String color, String suite) {
	        this.id = id;
	        this.owner = owner;
	        this.area = area;
	        this.number = number;
	        this.color = color;
	        this.suite = suite;
    }
    
    public Bedroom(String owner, float area, int number, String color, String suite) {
	        this.owner = owner;
	        this.area = area;
	        this.number = number;
	        this.color = color;
	        this.suite = suite;
    }
	
	
	
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
         return owner + ", " + area + ", "+ number + ", " + color + ", " + suite;
    }

}
