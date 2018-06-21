package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class driver {
	
	public static String licensePlate() {
		String letters = "";
		int x=0;
		while(x<3) {
			Random r = new Random();
			letters = letters + (char)(r.nextInt(26) + 'A');
			x=x+1;
		}
		return letters + "·" + ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
	}
	
	public static String car() {
		ArrayList<String> colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Oragne");
		colors.add("Green");
		colors.add("Blue");
		colors.add("White");
		colors.add("Black");
		colors.add("Gray");
		colors.add("Silver");
		
		ArrayList<String> makes = new ArrayList<String>();
		makes.add("Acura");
		makes.add("Buick");
		makes.add("BMW");
		makes.add("Mini");
		makes.add("Ford");
		makes.add("Jeep");
		makes.add("Toyota");
		makes.add("Nissan");
		makes.add("Honda");
		makes.add("Hyundai");
		makes.add("Chevy");
		makes.add("Chrystler");
		makes.add("Dodge");
		makes.add("Ram");
		return colors.get((new Random()).nextInt(colors.size())) + " " + makes.get((new Random()).nextInt(makes.size()));
	}
	
	public static void main(String[] args) {
		System.out.println(car());

	}
}
