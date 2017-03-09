package no.hib.dat102;

import java.util.Scanner;

import no.hib.dat102.liste.tabell.TabellOrdnetListe;

public class OrdnetMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		TabellOrdnetListe<Person> liste = new TabellOrdnetListe<>();
				
		int personsLeft = 5;
		while (personsLeft > 0) {
			liste.leggTil(UordnetMain.buildPerson(scanner));
			personsLeft--;
		}
				
		while (!liste.erTom()) {
			System.out.println(liste.fjernFoerste().toString());
		}
		
		scanner.close();
	}
}
