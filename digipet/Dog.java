package digipet;

public class Dog extends Pet {
	
	private int legs;
	
	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public Dog(String name, int legs) {
		super(name);
		this.legs = legs;
	}
		
	@Override
	public void speak() {
		System.out.println("\nWoof woof!\n");
	}
	
	public void stats() {
		System.out.printf("| %-10s : %-6s |\n", "Type", "Dog");
		System.out.printf("| %-10s : %-6s |\n", "Legs", legs);
		super.stats();
	}
}
