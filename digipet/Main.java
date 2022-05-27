/*
 * 2440009143 - Sheren Emanuela - LM01
 * TUGAS GSLC 1 - Digipet
 */

package digipet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		new Main();
		
	}
	
	public Main() {
		
		ArrayList<String> menuList = new ArrayList<>(
				List.of("Play", "Eat", "Bath", "Exit"));
		
		AvailablePet pets = initializePets();
		
		printWelcomeBanner();
		
		int command = -1;
		do {
			printPets(pets);
			printMenu(menuList);
			command = launchCommand(getCommand(menuList), pets);
		} while(command != 4);
		
	}
	
	private AvailablePet initializePets() {
		
		Dog dog = new Dog("Cookie", 4);
		Fish fish = new Fish("Floaty", 5);
		
		return new AvailablePet(dog, fish);
	}
	
	private void printWelcomeBanner() {
		System.out.println("=======================");
		System.out.println("| Welcome to DigiPet! |");
		System.out.println("=======================");
		System.out.println();
	}
	
	private void printPets(AvailablePet pets) {
		System.out.println("\n=======================");
		System.out.println("|     Pets Status     |");
		System.out.println("=======================");
		pets.getDog().stats();
		pets.getFish().stats();
		System.out.println();
	}
	
	private void printMenu(ArrayList<String> menuList) {
		System.out.println("=======================");
		System.out.println("|      Commands:      |");
		System.out.println("=======================");
		for(int i = 0; i < menuList.size(); i++) {
			System.out.printf("| %d. %-16s |\n", i+1, menuList.get(i));
		}
		System.out.println("=======================\n");	
	}
	
	private int getCommand(ArrayList<String> menuList) {
		int command = -1;
		do {
			System.out.printf("Please choose a command [1-%d]: ", menuList.size());	
			command = getIntegerInput();
			notifyCommandError(command, menuList);
		} while(command < 1 || command > 4);
		
		return command;
	}
	
	private int getIntegerInput() {
		int num = -1;
		
		try {
			num = input.nextInt();
		} catch (Exception e) {
			System.err.println("Input must be integer !");
		}
		input.nextLine();
		
		return num;
	}
	
	private void notifyCommandError(int command, ArrayList<String> menuList) {
		if((command < 1 || command > menuList.size()) && command != -1)
			System.err.println("Menu must be between 1 - 4 !");
	}
	
	private int launchCommand(int command, AvailablePet pets) {
		switch(command) {
		case 1:
			playMenu(pets);
			break;
		case 2:
			eatMenu(pets);
			break;
		case 3:
			bathMenu(pets);
			break;
		case 4:
			exitProgram();
			return 4;
		}
		return 0;
	}
	
	private boolean nameExists(String name) {
		if(!name.equalsIgnoreCase("Cookie") && !name.equalsIgnoreCase("Floaty"))
			return false;
		return true;
	}
	
	private String getNameInput() {
		String name;
		
		do {
			name = input.nextLine();
			
			if(!nameExists(name)) {
				System.err.println("Pet doesn't exist !");
				System.out.print("Input pet name again [Cookie | Floaty]: ");
			}
		} while (!nameExists(name));
		
		return name;
	}
	
	private void playMenu(AvailablePet pets) {
		
		System.out.printf("Choose a pet to play with [Cookie | Floaty]: ");
		
		String name = getNameInput();
		
		if(name.equalsIgnoreCase("Cookie")) {
			pets.getDog().play();
		}
		else {
			pets.getFish().play();
		}
	}
	
	private void eatMenu(AvailablePet pets) {
		
		System.out.printf("Choose a pet to play with [Cookie | Floaty]: ");
		
		String name = getNameInput();
		
		if(name.equalsIgnoreCase("Cookie")) {
			pets.getDog().eat();
		}
		else {
			pets.getFish().eat();
		}
	}
	
	private void bathMenu(AvailablePet pets) {
		
		System.out.printf("Choose a pet to play with [Cookie | Floaty]: ");
		
		String name = getNameInput();
		
		if(name.equalsIgnoreCase("Cookie")) {
			pets.getDog().bath();
		}
		else {
			pets.getFish().bath();
		}
	}
	
	public static void exitProgram() {
		System.out.println();
		System.out.println("See you again!");
	}

}
