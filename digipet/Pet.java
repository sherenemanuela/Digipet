package digipet;

public class Pet {
	
	private String name;
	private int happiness;
	private int health;
	private int cleanness;

	public void play() {
		if(this.health - 1 >= 0 && this.cleanness - 1 >= 0) {
			this.happiness += 3;
			this.health -= 1;
			this.cleanness -= 1;
			speak();
		}
		else {
			hungry();
			dirty();
		}
	}
	
	public void eat() {
		if(this.happiness - 1 >= 0 && this.cleanness - 1 >= 0) {
			happiness -= 1;
			health += 3;
			cleanness -= 1;
		}
		else {
			dirty();
			bored();
		}
	}
	
	public void bath() {
		if(this.health - 1 >= 0 && this.health - 1 >= 0) {
			happiness -= 1;
			health -= 1;
			cleanness += 3;
		}
		else {
			hungry();
			bored();
		}
	}
	
	public void speak() {
		System.out.println("Animal sound");
	}
	
	public void stats() {
		System.out.printf("| %-10s : %-6s |\n", "Name", name);
		System.out.printf("| %-10s : %-6s |\n", "Happiness", happiness);
		System.out.printf("| %-10s : %-6s |\n", "Health", health);
		System.out.printf("| %-10s : %-6s |\n", "Cleanness", cleanness);
		System.out.println("=======================");
	}
	
	private void bored() {
		if(this.happiness - 1 < 0)
			System.out.println(this.name + " is too bored !");
	}
	
	private void dirty() {
		if(this.cleanness - 1 < 0)
			System.out.println(this.name + " is too dirty !");
	}
	
	private void hungry() {
		if(this.health - 1 < 0)
			System.out.println(this.name + " is too hungry !");
	}
	
	public Pet(String name) {
		super();
		this.name = name;
		this.happiness = 10;
		this.health = 10;
		this.cleanness = 10;
	}

	public String getName() {
		return name;
	}
}
