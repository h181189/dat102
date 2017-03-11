package no.hib.dat102.recursion;

public class SolveTowers {
	
	public static void main(String[] args) {
		Hanoi towers = new Hanoi(16);
		
		long start = System.currentTimeMillis();
		towers.solve();
		long end = System.currentTimeMillis();
		
		int seconds = (int) (end-start)/1000;
		int milliseconds = (int) (end -start) % 1000;
		
		
		System.out.println(towers.getMovements());
		System.out.println("Time it took in seconds: " + seconds + "." + milliseconds);
	}
}
