package no.hib.dat102.oppgave2;

import no.hib.dat102.oppgave2.liste.DobbelKjedetOrdnetListeS;

public class KlientDobbeltOrdnetKjedetS {

	public static void main(String[] args) {

		String ord[] = { "o", "a", "s", "m", "e", "k", "c" };

		DobbelKjedetOrdnetListeS<String> liste = new DobbelKjedetOrdnetListeS(new String("AAA"), new String("zzz"));

		// Legger data inn i listen
		for (int i = 0; i < ord.length; i++)
			liste.leggTil(ord[i]);
		
		// Skriver ut liste
		System.out.println("\n\n Opprinnelig liste");
		liste.skrivListe();

		// Tester om et bestem element fins
		String element = new String("Kalle");

		boolean funnet = liste.fins(element);
		if (funnet)
			System.out.println("\nElementet " + element + " fins");
		else
			System.out.println("\nElementet " + element + " fins ikke");

		// Fjerner noen fra listen og skriver ut igjen

		String element1 = new String("a");
		String element2 = new String("m");
		String element3 = new String("e");
		String element4 = new String("o");
		String element5 = new String("k");
		String element6 = new String("c");
		String element7 = new String("s");

		System.out.println("\nFjerner " + element1);
		liste.fjern(element1);
		liste.skrivListe();
		System.out.println("\n\n");

		System.out.println("\nFjerner " + element2);
		liste.fjern(element2);
		liste.skrivListe();
		System.out.println("\n\n");

		System.out.println("\nFjerner " + element3);
		liste.fjern(element3);
		liste.skrivListe();
		System.out.println("\n\n");

		System.out.println("\nFjerner " + element4);
		liste.fjern(element4);
		liste.skrivListe();
		System.out.println("\n\n");

		System.out.println("\nFjerner " + element5);
		liste.fjern(element5);
		liste.skrivListe();
		System.out.println("\n\n");

		System.out.println("\nFjerner " + element6);
		liste.fjern(element6);
		liste.skrivListe();
		System.out.println("\n\n");

		System.out.println("\nFjerner " + element7);
		liste.fjern(element7);
		liste.skrivListe();
		System.out.println("\n\n");

	}
}// class
