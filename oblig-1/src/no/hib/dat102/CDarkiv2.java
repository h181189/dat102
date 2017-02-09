package no.hib.dat102;

import no.hib.dat102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

	private int antall;
	private LinearNode<CD> start;
	
	@Override
	public CD[] hentCdTabell() {
		CD[] tabell = new CD[antall];
		
		if (antall > 0) {
		LinearNode<CD> current = start;
			for (int i = 0; i < antall; i++) {
				tabell[i] = current.getElement();
				current = current.getNeste();
			}
		}
		return tabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> newNode = new LinearNode<>(nyCd);
		newNode.setNeste(start);
		start = newNode;
	}

	@Override
	public boolean slettCd(int cdNr) {
		LinearNode<CD> current = start;
		LinearNode<CD> previous = null;
		boolean found = false;
		
		for (int i = 0; i < antall && !found; i++) {
			if (current.getElement().getNummer() == cdNr) {
				found = true;
				if (previous == null) {
					start = current.getNeste();
				} else {
					previous.setNeste(current.getNeste());
				}
			}
			previous = current;
			current = current.getNeste();
		}
		
		return found;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] treff = new CD[antall];
		int antallTreff = 0;
		LinearNode<CD> current = start;
		for (int i = 0; i < antall; i++) {
			if (current.getElement().getTittel().contains(delstreng)) {
				treff[antallTreff++] = current.getElement();
			}
		}
		return trimTabell(treff, antallTreff);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] treff = new CD[antall];
		int antallTreff = 0;
		LinearNode<CD> current = start;
		for (int i = 0; i < antall; i++) {
			if (current.getElement().getArtist().contains(delstreng)) {
				treff[antallTreff++] = current.getElement();
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
		int antallTreff = 0;
		LinearNode<CD> current = start;
		for (int i = 0; i < antall; i++) {
			if (current.getElement().getSjanger() == sjanger) {
				antallTreff++;
			}
			current = current.getNeste();
		}
		return antallTreff;
	}

	private CD[] trimTabell(CD[] samling, int nyLengde) {
		CD[] trimmetArkiv = new CD[nyLengde];
		for (int i = 0; i < Math.min(samling.length, nyLengde); i++) {
			trimmetArkiv[i] = samling[i];
		}
		return trimmetArkiv;
	}
}
