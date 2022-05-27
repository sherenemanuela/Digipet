package digipet;

public class Fish extends Pet {

	private int fins;
	
	public int getFins() {
		return fins;
	}

	public void setFins(int fins) {
		this.fins = fins;
	}

	public Fish(String name, int fins) {
		super(name);
		this.fins = fins;
	}
	
	@Override
	public void speak() {
		System.out.println("\nGulu gulu...\n");
	}
	
	public void stats() {
		System.out.printf("| %-10s : %-6s |\n", "Type", "Fish");
		System.out.printf("| %-10s : %-6s |\n", "Fins", fins);
		super.stats();
	}
}
