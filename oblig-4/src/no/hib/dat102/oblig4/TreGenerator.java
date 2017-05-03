package no.hib.dat102.oblig4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreGenerator {
	
	private final Random random = new Random();
	
	private int antallNoder = 0;
	private int maksTeoretiskHoyde;
	private int minTeoretiskHoyde;
	private int minsteHoyde;
	private int storsteHoyde;
	private double avgHoyde = 0;
	private int totalHoyde = 0;
	
	private final List<BSTreADT<Integer>> traer = new ArrayList<>();

	public TreGenerator(int antallNoder) {
		if (antallNoder < 0) {
			throw new IllegalArgumentException("number of nodes cannot be less than 0: " + antallNoder);
		}
		
		this.maksTeoretiskHoyde = antallNoder - 1;
		this.minTeoretiskHoyde = (int) (Math.log10((double) antallNoder) / Math.log10(2.));
		this.minsteHoyde = maksTeoretiskHoyde;
		this.storsteHoyde = minTeoretiskHoyde;
		this.antallNoder = antallNoder;
	}
	
	private KjedetBSTre<Integer> lagTre() {
		KjedetBSTre<Integer> tre = new KjedetBSTre<>();
		
		for (int i = 0; i < antallNoder; i++) {
			tre.leggTil(random.nextInt());
		}
		
		int hoyde = tre.finnHoyde();
		minsteHoyde = Math.min(minsteHoyde, hoyde);
		storsteHoyde = Math.max(storsteHoyde, hoyde);
		
		totalHoyde += hoyde;
		
		traer.add(tre);
		return tre;
	}
	
	public List<BSTreADT<Integer>> lagTraer(int antall) {
		List<BSTreADT<Integer>> traer = new ArrayList<>(antall);
		for (int i = 0; i < antall; i++) {
			traer.add(lagTre());
		}
		
		this.avgHoyde = (double) totalHoyde / this.traer.size();
		
		return traer;
	}
	
	public int getMaksTeoretiskHoyde() {
		return maksTeoretiskHoyde;
	}
	
	public int getMinTeoretiskHoyde() {
		return minTeoretiskHoyde;
	}
	
	public int getAntallNoder() {
		return antallNoder;
	}
	
	public int getStorsteHoyde() {
		return storsteHoyde;
	}
	
	public int getMinsteHoyde() {
		return minsteHoyde;
	}
	
	public double getAvgHoyde() {
		return avgHoyde;
	}
	
}
