package no.hib.dat102.mengde.klient;

import java.util.Iterator;
import java.util.Scanner;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class Ordliste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MengdeADT<String> ordListe1 = new TabellMengde<String>();// Tilsvarende for TabellMengde

		String[] ord = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		Scanner tastatur = new Scanner(System.in);
		// Legger til ordene i mengden ordListe1

		for (int i = 0; i < ord.length; i++) {
			ordListe1.leggTil(ord[i]);
		}
		KjedetMengde<String> ordListe2 = new KjedetMengde<String>();

		System.out.print("Oppgi en streng, avslutt med zzz :");
		String streng = tastatur.nextLine();
		// Leser inn ord
		while (!streng.equals("zzz")) {
			
			if (ordListe2.inneholder(streng)) {
				System.out.println("Ordet finnes allerede");
			} else {
				ordListe2.leggTil(streng);
				Iterator<String> it = ordListe2.oppramser();
				while (it.hasNext()) {
					System.out.print(it.next() + " ");
				}
				System.out.println();
				System.out.println();
			}
			
			System.out.print("Oppgi en streng, avslutt med zzz :");
			streng = tastatur.nextLine();
		} // while

		// Lager unionen av de to ordlistene
		MengdeADT<String> ordListeBegge = (TabellMengde<String>) ordListe1.union(ordListe2);
		System.out.println();
		System.out.println("Utskrift av unionen av begge ordlistene");
		
		//... Fyll ut
		Iterator<String> it = ordListeBegge.oppramser();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		
		// Lager snittet av de to ordlistene
		MengdeADT<String> ordListeFelles = (TabellMengde<String>) ordListe1.snitt(ordListe2);
		System.out.println();
		System.out.println("Utskrift av snittet av begge ordlistene");
        //...Fyll ut
		Iterator<String> it2 = ordListeFelles.oppramser();
		while (it2.hasNext()) {
			System.out.print(it2.next() + " ");
		}
		System.out.println();

		// Lager differansen av de to ordlistene
		MengdeADT<String> ordListeDiff = (TabellMengde<String>) ordListe1.differens(ordListe2);
		System.out.println();
		System.out.println("Utskrift av differansen av begge ordlistene");

		while (!ordListeDiff.erTom()) {
			System.out.print(ordListeDiff.fjernTilfeldig() + " ");
		}
		
	}
	
}
