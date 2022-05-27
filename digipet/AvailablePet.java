package digipet;

public class AvailablePet {
	private Dog dog;
	private Fish fish;
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Fish getFish() {
		return fish;
	}
	public void setFish(Fish fish) {
		this.fish = fish;
	}
	public AvailablePet(Dog dog, Fish fish) {
		super();
		this.dog = dog;
		this.fish = fish;
	}
	
	
}
