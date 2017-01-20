package no.hib.dat102;

import java.util.Scanner;

import no.hib.dat102.adt.CDarkivADT;

public class Tekstgrensesnitt {
	
	/**
	 * Lese opplysninger om en CD fra tastatur
	 * 
	 */
	public CD lesCD() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hvilket nummer har CD-en?");
		int nummer = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Hvilken artist/gruppe?");
		String artist = scanner.nextLine();
		
		System.out.println("Hvilken tittel har CD-en?");
		String tittel = scanner.nextLine();
		
		System.out.println("Hvilket årstall ble CD-en utgitt?");
		int dato = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Hvilken sjanger har CD-en?");
		Sjanger sjanger = Sjanger.valueOf(scanner.nextLine().toUpperCase());
		
		System.out.println("Hvilket plateselskap hører CD-en til?");
		String plateselskap = scanner.nextLine();
		
		return new CD(nummer, artist, tittel, dato, sjanger, plateselskap);
	}
	
	/**
	 * Vise en CD med alle opplysninger på skjerm
	 * 
	 */
	public void visCD(CD cd) {
		System.out.println("Nummer: " + cd.getNummer());
		System.out.println("Artist/gruppe: " + cd.getArtist());
		System.out.println("Tittel: " + cd.getTittel());
		System.out.println("År: " + cd.getDato());
		System.out.println("Sjanger: " + cd.getSjanger());
		System.out.println("Plateselskap: " + cd.getPlateselskap());
	}
	
	/**
	 * Skrive ut alle CD-er med gitt delstreng i tittelen
	 * 
	 */
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		CD[] treff = cda.sokTittel(delstreng);
		for (CD cd : treff) {
			visCD(cd);
			System.out.println();
		}
	}
	
	/**
	 * Skriv ut alle CD-er av en artist
	 * 
	 */
	public void skrivUtCdArtist(CDarkivADT cda, String artist) {
		CD[] alle = cda.sokArtist(artist);

		for (CD cd : alle) {
			visCD(cd);
			System.out.println();
		}
	}
	
	/**
	 * Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	 * og hvor mange det er i hver sjanger
	 */
	public void skrivUtStatistikk(CDarkivADT cda) {
		System.out.println("CD-er totalt: " + cda.hentAntall());
		for (Sjanger sjanger : Sjanger.values()) {
			if (cda.hentAntall(sjanger) > 0) {
				System.out.println(sjanger + ": " + cda.hentAntall(sjanger));
			}
		}
	}
}
