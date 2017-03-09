package no.hib.dat102;

import java.util.Scanner;

import no.hib.dat102.ko.KoeADT;
import no.hib.dat102.ko.TabellKoe;

public class UordnetMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		KoeADT<Person> ko = new TabellKoe<>();

		int personsLeft = 5;
		while (personsLeft > 0) {
			ko.innKoe(buildPerson(scanner));
			personsLeft--;
		}
		
		while (!ko.erTom()) {
			System.out.println(ko.utKoe().toString());
		}
		
		scanner.close();
	}
	
	public static Person buildPerson(Scanner scanner) {
		System.out.println("Fodselsar:");
		String fodselsar = scanner.nextLine();

		System.out.println("Fornavn:");
		String fornavn = scanner.nextLine();

		System.out.println("Etternavn:");
		String etternavn = scanner.nextLine();
		
		return new Person(fodselsar, fornavn, etternavn);
	}
}
