package no.hib.dat102.hobby;

import java.util.Iterator;

import no.hib.dat102.mengde.tabell.TabellMengde;

public class DataKontakt {

	private TabellMengde<Medlem> medlemmer = new TabellMengde<>();
	private int antall = 0;

	/**
	 * Legger til et medlem
	 * @param medlem
	 */
	public void leggTil(Medlem medlem) {
		medlemmer.leggTil(medlem);
		antall = medlemmer.antall();
	}

	/**
	 * @param navn
	 * @return indeks
	 */
	public int finnMedlemsIndeks(String navn) {
		int indeks = -1;

		Iterator<Medlem> it = medlemmer.oppramser();
		int counter = 0;
		while (it.hasNext() && indeks == -1) {
			if (it.next().getNavn().equalsIgnoreCase(navn)) {
				indeks = counter;
			}
			counter++;
		}

		return indeks;
	}

	/**
	 * 
	 * @param navn
	 * @return medlem med gitt navn
	 */
	public Medlem finnMedlem(String navn) {
		int indeks = finnMedlemsIndeks(navn);
		if (indeks == -1) {
			return null;
		}

		Iterator<Medlem> it = medlemmer.oppramser();
		Medlem m1 = null;
		int counter = 0;
		while (counter <= indeks) {
			m1 = it.next();
			counter++;
		}
		return m1;
	}

	/**
	 * @param navn
	 * @return partner for gitt medlem
	 */
	public Medlem finnPartnerFor(String navn) {
		Medlem m1 = finnMedlem(navn);
		if (m1 == null) {
			return null;
		}

		Medlem treff = null;
		Medlem mulig = null;
		Iterator<Medlem> it = medlemmer.oppramser();
		while (it.hasNext() && treff == null) {
			mulig = it.next();
			if (mulig.passerTil(m1)) {
				treff = mulig;
			}
		}
		return treff;
	}

	/**
	 * Finner og tilbakestiller statusindeks til medlem(mene).
	 * 
	 * @param medlemsnavn
	 */
	public void tilbakestillStausIndeks(String medlemsnavn) {
		Medlem m1 = finnMedlem(medlemsnavn);
		if (m1 == null) {
			return;
		}

		int indeks = m1.getStatusIndeks();
		Medlem m2 = finnMedlemMedIndeks(indeks);
		m1.nullstillStatusIndeks();
		if (m2 != null) {
			m2.nullstillStatusIndeks();
		}
	}

	public Medlem finnMedlemMedIndeks(int indeks) {
		if (indeks >= medlemmer.antall()) {
			return null;
		}
		
		Iterator<Medlem> it = medlemmer.oppramser();
		Medlem medlem = it.next();
		for (int i = 0; i < indeks; i++) {
			medlem = it.next();
		}
		
		return medlem;
	}

	/**
	 * Setter to medlemmer sammen
	 * 
	 */
	public void settSammen(Medlem m1, Medlem m2) {
		m1.setStatusIndeks(finnMedlemsIndeks(m2.getNavn()));
		m2.setStatusIndeks(finnMedlemsIndeks(m1.getNavn()));
	}

	/**
	 * 
	 * @return iterator for medlemene.
	 */
	public Iterator<Medlem> getMedlemIterator() {
		return medlemmer.oppramser();
	}
	
	/**
	 * 
	 * @return antall medlemmer
	 */
	public int antall() {
		return antall;
	}
}
