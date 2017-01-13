package no.hib.dat102;

public class Butikk {
	
	private String navn;
	
	private Vare[] varer;
	private int[] lager;
	private int forsteLedig;
	
	
	public Butikk(String navn, int maksVarer) {
		this.navn = navn;
		this.varer = new Vare[maksVarer];
		this.lager = new int[maksVarer];
		forsteLedig = 0;
	}
	
	public int finnVare(int varenr) {
		int indeks = -1;
		for (int i = 0; i < forsteLedig && indeks == -1; i++) {
			if (varer[i].getVarenummer() == varenr) {
				indeks = i;
			}
		}
		return indeks;
	}
	
	public boolean erLedigPlass() {
		return forsteLedig != varer.length;  
	}
	
	public void leggInnNyVare(int varenr) {
		if (!erLedigPlass()) {
			System.out.println("Det er ikke plass til flere varer");
		} else if (finnVare(varenr) != -1) {
			System.out.println("Varen finnes fra før");
		} else {
			Vare vare = new Vare(varenr);
			vare.lesVare();
			varer[forsteLedig] = vare;
			forsteLedig++;
		}
	}
	
	public void slettVare(int varenr) {
		int indeks = finnVare(varenr);
		if (indeks == -1) {
			System.out.println("Varen finnes ikke");
		} else {
			varer[indeks] = varer[forsteLedig - 1] != null ? varer[forsteLedig - 1] : null;
			forsteLedig--;
		}
	}
	
	public void detaljKjop(int varenr) {
		int indeks = finnVare(varenr);
		if (indeks == -1) {
			System.out.println("Varen finnes ikke");
		} else {
			if (lager[indeks] == 0) {
				System.out.println("Det er ikke flere av denne varen");
			} else {
				lager[indeks]--;
			}
		}
	}
	
	public void grossKjop(int varenr, int tall) {
		int indeks = finnVare(varenr);
		if (indeks == -1) {
			System.out.println("Varen finnes ikke");
		} else if(tall < 0) {
			System.out.println("Kan ikke kjøpe inn et negativt tall varer");
		} else {
			lager[indeks] += tall;
		}
	}
	
	public double salgsVerdi() {
		double total = 0;
		for (int i = 0; i < forsteLedig; i++) {
			total += (varer[i].getPris() * lager[i]);
		}
		return total;
	}
	
}
