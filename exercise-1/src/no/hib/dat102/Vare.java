package no.hib.dat102;

import java.util.Objects;
import java.util.Scanner;

public class Vare {
	
	private int varenummer;
	private String navn;
	private double pris;
	
	public Vare(int varenummer, String navn, double pris) {
		Objects.requireNonNull(navn);
		this.varenummer = varenummer;
		this.navn = navn;
		this.pris = pris;
	}
	
	public Vare(int varenummer) {
		this(varenummer, "", 0);
	}
	
	public Vare() {
		this(0, "", 0);
	}

	public int getVarenummer() {
		return varenummer;
	}

	public void setVarenummer(int varenummer) {
		this.varenummer = varenummer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		Objects.requireNonNull(navn);
		this.navn = navn;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public void lesVare() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Skriv inn navnet til varen:");
		String navn = input.nextLine();
		
		System.out.println("Skriv inn prisen til varen:");
		double pris = input.nextDouble();
		while (pris < 0) {
			System.out.println("Prisen kan ikke være negativ. Skriv inn en ny verdi:");
			pris = input.nextDouble();
		}
		
		this.navn = navn;
		this.pris = pris;
	}
	
}
