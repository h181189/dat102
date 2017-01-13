package no.hib.dat102;

public class Exercise {

	public static void main(String[] args) {
		Butikk butikk = new Butikk("Rema 1000", 100);
		
		for (int i = 0; i < 3; i++) {
			butikk.leggInnNyVare(i + 1);
			butikk.grossKjop(i + 1, (int) Math.round(Math.random() * i + 10) + 30);
			System.out.println();
		}
				
		System.out.println("Alle varer koster: " + butikk.salgsVerdi());
		
		butikk.slettVare(2);
		System.out.println("Vare slettet");
		butikk.detaljKjop(3);
		System.out.println("Detalj kjøp 3");
		butikk.detaljKjop(1);
		System.out.println("Detalj kjøp 1");
		butikk.finnVare(100);
		System.out.println("Fant vare 100");
		
		System.out.println("Alle varer koster: " + butikk.salgsVerdi());
	}
	
}
