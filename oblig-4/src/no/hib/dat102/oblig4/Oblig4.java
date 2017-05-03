package no.hib. dat102.oblig4;

public class Oblig4 {
	public static void main(String[] args) {
		TreGenerator gen = new TreGenerator(1024);
		gen.lagTraer(1000);
		TreGenerator gen2 = new TreGenerator(4096);
		gen2.lagTraer(1000);
		
		System.out.println(gen.getAvgHoyde());
		System.out.println(gen2.getAvgHoyde());
	}
}
