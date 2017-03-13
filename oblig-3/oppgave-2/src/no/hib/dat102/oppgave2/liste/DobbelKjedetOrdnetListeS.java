package no.hib.dat102.oppgave2.liste;

/**
 * 
 * DobbeKjedetlOrdnetListeS.java // // Representerer en dobbeltkjedet ordnet
 * liste med midtpeker.
 **/
import no.hib.dat102.oppgave2.DobbelNode;

public class DobbelKjedetOrdnetListeS<T extends Comparable<T>> implements DobbelKjedetOrdnetListeSADT<T> {

	private DobbelNode<T> foerste;
	private DobbelNode<T> midten;
	private DobbelNode<T> siste;
	private int antall;

	/**
	 * Oppretter en tom liste.
	 **/

	public DobbelKjedetOrdnetListeS(T minVerdi, T maksVerdi) {

		// F�rste node
		DobbelNode<T> nyNode1 = new DobbelNode<T>(minVerdi);
		foerste = nyNode1;
		midten = foerste;

		// Siste node
		DobbelNode<T> nyNode2 = new DobbelNode<T>();
		nyNode2.setElement(maksVerdi);
		nyNode1.setNeste(nyNode2);
		nyNode2.setForrige(nyNode1);
		siste = nyNode2;

		antall = 0;
	}

	public void leggTil(T el) {
		// Setter inn ordnet f�r den noden p peker p�
		DobbelNode<T> p;

		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier

			antall++;

			if (el.compareTo(midten.getElement()) >= 0) {// Finn plass i siste
				p = midten.getNeste();
			} else { // Finn plass i f�rste halvdel
				p = foerste.getNeste();
			}

			while (p != null && el.compareTo(p.getElement()) >= 0) {
				p = p.getNeste();
			} // while
			// Setter inn:
			// Innsett foran noden som p peker p�
			p = p.getForrige();

			// Fyll ut med noen f� setninger
			DobbelNode<T> nyNode = new DobbelNode<T>(el);
			nyNode.setNeste(p.getNeste());
			nyNode.setForrige(p);
			p.setNeste(nyNode);
			nyNode.getNeste().setForrige(nyNode);
			
			// Oppdaterer ny midten
			if (antall % 2 == 0) {
				midten = midten.getNeste();
			}
		} // else lovlige

	}//

	// **********************************************************************************
	// Hjelpemetode til � finne ny midten.
	// Mindre effektiv fordi vi m� gjennomg� ca halve listen, men greit nok,
	// ellers kan en teste p� om antall er partall er oddetall ved oppdatering
	// av midtpeker
	// *********************************************************************************
	private void nyMidten() {
		int midtNR = antall / 2;
		DobbelNode<T> p = foerste.getNeste();
		for (int i = 1; i <= midtNR; i++) {
			p = p.getNeste();
		}
		midten = p;
	}//

	//
	// *
	// *
	//
	public boolean fins(T el) {
		boolean funnet = false;
		DobbelNode<T> p = null;
		if ((el.compareTo(foerste.getElement()) <= 0) || (el.compareTo(siste.getElement()) >= 0)) {
			// Ugyldig. Alternativt kan vi ha det som et forkrav!
			System.out.println("Ugyldig verdi. verdi > " + foerste.getElement() + "verdi < " + siste.getElement());

		} else { // Kun lovlige verdier
			if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
				p = midten; // Midten defineres � tilh�re siste del
			} else { // Let i f�rste halvdel
				p = foerste.getNeste();
			}

			while (el.compareTo(p.getElement()) > 0) {
				p = p.getNeste();
			} // while

			// Test p� funnet
			if (el.compareTo(p.getElement()) == 0) {
				funnet = true;
			}
		} // else
		return funnet;
	}//

	public T fjern(T el) {
		DobbelNode<T> p = finn(el);
		T resultat = null;
		if (p != null) {
			// Tar ut
			antall--;
			// Fyll ut med noen f� setninger.
			p.getForrige().setNeste(p.getNeste());
			p.getNeste().setForrige(p.getForrige());
			// Oppadtere midten
			if (antall % 2 == 0) {
				midten = midten.getForrige();
			} else {
				midten = midten.getNeste();
			}

			resultat = p.getElement();

		} // funnet

		return resultat;
	}//

	/* Alternativ kan fjern-metoden bruke finn-metoden */

	private DobbelNode<T> finn(T el) {
		DobbelNode<T> node = null;
		DobbelNode<T> p = null;

		// Kun lovlige verdier
		if (el.compareTo(midten.getElement()) >= 0) { // Let i siste halvdel
			p = midten; // Midten defineres � tilh�re siste del
		} else { // Let i f�rste halvdel
			p = foerste.getNeste();
		}
		while (el.compareTo(p.getElement()) > 0) {
			p = p.getNeste();
		} // while

		// Test p� funnet
		if (el.compareTo(p.getElement()) == 0) {
			node = p;
		}
		return node;
	}

	public void skrivListe() {
		DobbelNode<T> p = foerste;

		while (p != null) {
			System.out.print(p.getElement() + " ");
			p = p.getNeste();
		}
		System.out.println(
				"Foerste:" + foerste.getElement() + " Midten:" + midten.getElement() + " Siste:" + siste.getElement());
		System.out.println();

	}//

}// class
