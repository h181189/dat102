package no.hib.dat102.hobby;

import java.util.Iterator;
import java.util.Scanner;

import no.hib.dat102.mengde.tabell.TabellMengde;

public class Klient {
	
	private final Scanner scanner = new Scanner(System.in);
	private DataKontakt data = new DataKontakt();
	
	public static void main(String[] args) {
		Klient klient = new Klient();
		klient.run();
	}
	
	/**
	 * Kjører klientprogrammet
	 * 
	 */
	public void run() {
		int valg;
		do {
			printMeny();

			try {
				valg = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				valg = 100;
			}
			
			velgTjeneste(valg);
		} while (valg != 0);
		
	}
	
	/**
	 * Printer ut menyen
	 * 
	 */
	private void printMeny() {
		System.out.println("1) Legg til medlem");
		System.out.println("2) Legg til hobby for medlem");
		System.out.println("3) Finn partner for medlem");
		System.out.println("4) Tilbakestill statusindeks for medlem");
		System.out.println("5) Skriv liste med par");
		System.out.println("6) Skriv ut hobbyer til et medlem");
		System.out.println("7) Last inn ferdiglagde medlemmer.");
		
		System.out.println("0) Avslutt");
	}
	
	/**
	 * Velger en tjeneste fra menyen
	 * 
	 * @param valg
	 */
	private void velgTjeneste(int valg) {
		switch(valg) {
		case 1:
			leggTilMedlem();
			break;
		case 2:
			leggTilHobby();
			break;
		case 3:
			finnPartner();
			break;
		case 4:
			tilbakestillPartnere();
			break;
		case 5:
			skrivUtPar();
			break;
		case 6:
			skrivUtHobbyer();
			break;
		case 7:
			lastInn();
			break;
		case 0:
			System.out.println("Velkommen igjen.");
			System.exit(3);
		default:
			System.out.println("Dette var ikke et valg! Prøv igjen.");
		}
		System.out.println();
	}
	
	public void leggTilMedlem() {
		System.out.println("Skriv navn:");
		String navn = scanner.nextLine();
		
		data.leggTil(new Medlem(navn));
	}
	
	/**
	 * Legger til hobby for et medlem
	 * 
	 */
	public void leggTilHobby() {
		System.out.println("Hvem vil du legge til hobby for?");
		String navn = scanner.nextLine();
		
		Medlem m1 = data.finnMedlem(navn);
		if (m1 != null) {
			String hobby;
			boolean fortsett;
			do {
				System.out.println("Skriv en hobby: (skriv 'avslutt' eller '' for å gå tilbake til menyen)");
				hobby = scanner.nextLine();
				fortsett = !hobby.equalsIgnoreCase("avslutt") && !hobby.isEmpty();
				if (fortsett) { 
					m1.leggTilHobby(hobby);
				}
				
				System.out.println(m1.getNavn() + " interesserer seg for " + m1.getHobbyer().toString() + "!");
				System.out.println();
			} while (fortsett);
		} else {
			System.out.println("Fant ikke medlemmet.");
		}
	}
	
	/**
	 * Finner en passende partner for medlem
	 * 
	 */
	public void finnPartner() {
		System.out.println("Hvem vil du finne partner for?");
		String navn = scanner.nextLine();
		
		Medlem m1 = data.finnMedlem(navn);
		if (m1 != null) {
			Medlem m2 = data.finnPartnerFor(m1.getNavn());			
			if (m2 != null) {
				System.out.println(m1.getNavn() + " og " + m2.getNavn() + " er en match!");
				data.settSammen(m1, m2);
			} else {
				System.out.println("Fant ingen treff for denne ensomheten...");
			}
		} else {
			System.out.println("Fant ikke et medlem med dette navnet.");
		}
	}
	
	/**
	 * Tilbakestiller indeksen til et medlem og dens partner 
	 */
	public void tilbakestillPartnere() {
		System.out.println("Hvem vil du tilbakestille medlemskap for?");
		String navn = scanner.nextLine();
		
		data.tilbakestillStausIndeks(navn);
	}
	
	/**
	 * Skriver ut alle medlemspar
	 * 
	 */
	public void skrivUtPar() {
		Iterator<Medlem> it = data.getMedlemIterator();
		TabellMengde<Integer> indekser = new TabellMengde<>();
		
		System.out.println("Par og interesser:");
		
		while (it.hasNext()) {
			Medlem m1 = it.next();
			if (m1.getStatusIndeks() != -1) {
				if (!indekser.inneholder(data.finnMedlemsIndeks(m1.getNavn()))) {
					Medlem m2 = data.finnMedlemMedIndeks(m1.getStatusIndeks());
					
					System.out.println(m1.getNavn() + " og " + m2.getNavn() + " interesserer seg for :\t" + m1.getHobbyer().toString());
					indekser.leggTil(m1.getStatusIndeks());
					indekser.leggTil(m2.getStatusIndeks());
				}
			}
		}
	}
	
	/**
	 * Skriver ut hobbyer til et medlem
	 * 
	 */
	public void skrivUtHobbyer() {
		System.out.println("Hvem sine hobbyer vil du se?");
		String name = scanner.nextLine();
		
		Medlem m = data.finnMedlem(name);
		if (m != null) {
			System.out.println(m.getHobbyer().toString());
		} else {
			System.out.println("Fant ikke et medlem med dette navnet.");
		}
	}
	
	/**
	 * Laster inn forhåndsskrevet informasjon
	 */
	public void lastInn() {
		Medlem m1 = new Medlem("Rudolf");
		Medlem m2 = new Medlem("Guro");
		Medlem m3 = new Medlem("Lamar");
		Medlem m4 = new Medlem("Kjell Magne");
		Medlem m5 = new Medlem("Leif Didrik");
		Medlem m6 = new Medlem("Ulf Helga");
		
		String[] hobby = {
				"å krype på gatene i Oslo",
				"å påstå at fremmede er ens fedre",
				"å forsøke å puste under vann",
				"å kaste mat i bosset foran fattige",
		};
		
		m1.leggTilHobby(hobby[0]);
		m1.leggTilHobby(hobby[2]);
		
		m2.leggTilHobby(hobby[1]);
		m3.leggTilHobby(hobby[1]);
		
		m4.leggTilHobby(hobby[3]);
		m4.leggTilHobby(hobby[2]);
		m5.leggTilHobby(hobby[3]);
		m5.leggTilHobby(hobby[2]);
		
		m6.leggTilHobby(hobby[1]);
		
		int antall = data.antall();
		
		m2.setStatusIndeks(antall + 2);
		m3.setStatusIndeks(antall + 1);
		
		m4.setStatusIndeks(antall + 4);
		m5.setStatusIndeks(antall + 3);
		
		
		data.leggTil(m1);
		data.leggTil(m2);
		data.leggTil(m3);
		data.leggTil(m4);
		data.leggTil(m5);
		data.leggTil(m6);
	}
	
}
