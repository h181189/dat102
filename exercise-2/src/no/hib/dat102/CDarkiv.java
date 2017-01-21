package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT{

	private CD[] arkiv;
	private int antall = 0;

	public CDarkiv(int lengde) {
		if (lengde == 0) {
			throw new IllegalArgumentException("kan ikke utvide tabellen dersom lengden er 0");
		}
		arkiv = new CD[lengde];
	}
	
	public CDarkiv() {
		this(10);
	}
	
	@Override
	public CD[] hentCdTabell() {
		return trimTabell(arkiv, antall);
	}

	@Override
	public void leggTilCd(CD nyCd) {
		if (antall == arkiv.length) {
			utvidTabell();
		}

		arkiv[antall] = nyCd;
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		int indeks = -1;
		for (int i = 0; i < arkiv.length && indeks == -1; i++) {
			if (cdNr == arkiv[i].getNummer()) {
				indeks = i;
			}
		}
		arkiv[indeks] = arkiv[antall - 1];
		arkiv[--antall] = null;
		
		return false;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] treff = new CD[arkiv.length];
		int antallTreff = 0;
		for (int i = 0; i < antall; i++) {
			CD cd = arkiv[i];
			if (cd.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				treff[antallTreff] = cd;
				antallTreff++;
			}
		}
		
		return trimTabell(treff, antallTreff);
	}

	@Override
	public CD[] sokArtist(String artist) {
		CD[] treff = new CD[arkiv.length];
		int antallTreff = 0;
			for (int i = 0; i < antall; i++) {
				CD cd = arkiv[i];
				if (cd.getArtist().equalsIgnoreCase(artist)) {
					treff[antallTreff] = cd;
					antallTreff++;
				}
			}

		return trimTabell(treff, antallTreff);
	}

	@Override
	public int hentAntall() {
		return antall;
	}
	
	@Override
	public int hentAntall(Sjanger sjanger) {
		int antall = 0;
		for (CD cd : arkiv) {
			if (cd.getSjanger() == sjanger) {
				antall++;
			}
		}
		
		return antall;
	}
	
	public void utvidTabell() {
		CD[] temp = new CD[(int) Math.ceil(arkiv.length * 1.1)];
		for (int i = 0; i < arkiv.length; i++) {
			temp[i] = arkiv[i];
		}
		arkiv = temp;
	}
	
	public CD[] trimTabell(CD[] samling, int nyLengde) {
		CD[] trimmetArkiv = new CD[nyLengde];
		for (int i = 0; i < Math.min(samling.length, nyLengde); i++) {
			trimmetArkiv[i] = samling[i];
		}
		return trimmetArkiv;
	}
}
