package no.hib.dat102.recursion;

public class Recursion {
	
	public static void main(String[] args) {
		System.out.println(sum(100));
		
		for(int i = 0; i < 10; i++) {
			System.out.println(sequence(i));
		}
	}
	
	public static int sum(int number) {
		
		if(number == 1) {
			return 1;
		} else {
			return number + sum(number-1);
		}
	}
	
	public static int sequence(int number) {
		if (number == 0) {
			return 2;
		} else if(number == 1) { 
			return 5;
		} else {
			return 5 * sequence(number - 1) - 6 * sequence(number - 2) + 2;
		}
	}
}
