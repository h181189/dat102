package no.hib.dat102.recursion;

public class Hanoi {
	private int totalDisks;
	private long movements;
	
	public Hanoi(int disks){
		totalDisks = disks;
	}
	
	public void solve() {
		moveTower(totalDisks, 1, 3, 2);
	}
	
	private void moveTower(int numDisks, int start, int end, int temp) {
		if(numDisks == 1) {
			moveOneDisk(start, end);
		} else {
			moveTower(numDisks-1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks-1, temp, end, start);
		}
	}
	
	private void moveOneDisk(int start, int end) {
		movements++;
	}
	
	public long getMovements() {
		return movements;
	}
}
