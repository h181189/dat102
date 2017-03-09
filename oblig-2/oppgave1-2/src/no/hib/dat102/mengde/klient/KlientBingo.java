package no.hib.dat102.mengde.klient;

import no.hib.dat102.mengde.adt.MengdeADT;

public abstract class KlientBingo {
	// Oppretter 2 mengder med 75 bingokuler i hver.
	// Tester om en spesiell bingokule er med i den ene mengden,
	// og om de to mengdene er n�yaktig like.

	protected abstract MengdeADT<Bingokule> lagNyMengde();
	
	public void run() {
		final int ANTALL_BALLER = 75;
		MengdeADT<Bingokule> minMengde1 = lagNyMengde();
		MengdeADT<Bingokule> minMengde2 = lagNyMengde();
		Bingokule kule1 = null;
		Bingokule kule2 = null;

		for (int i = 1; i <= ANTALL_BALLER; i++) {
			kule1 = new Bingokule(i);
			kule2 = new Bingokule(ANTALL_BALLER + 1 - i);
			minMengde1.leggTil(kule1);
			minMengde2.leggTil(kule2);
		}

		System.out.println("\nAntall kuler totalt: " + minMengde1.antall());
		System.out.println();

		kule1 = new Bingokule(10);
		if (minMengde1.inneholder(kule1)) {
			System.out.println("kule 1 funnet i mengde 1");
		}

		if (minMengde1.erLik(minMengde2)) {
			System.out.println("Like mengder");
		}
		
		minMengde1.fjern(kule1);
		if (!minMengde1.erLik(minMengde2)) {
			System.out.println("Ulike mengder");
		}
		
	}
}// class