package no.hib.dat102.adt;

import no.hib.dat102.CD;
import no.hib.dat102.Sjanger;

public interface CDarkivADT {
	
	/**
	 * 
	 * @return tabell av CD-er
	 */
	CD[] hentCdTabell();

	/**
	 * Legger til en ny CD til arkivet
	 * 
	 */
	void leggTilCd(CD nyCd);

	/**
	 * Fjerner en CD fra arkivet 
	 * 
	 * @return om slettingen var vellykket
	 */
	boolean slettCd(int cdNr);

	/**
	 * Sæker og henter titler med en gitt delstreng
	 * 
	 */
	CD[] sokTittel(String delstreng);
	
	/**
	 * Søker og henter artister med en gitt delstreng
	 * 
	 */
	CD[] sokArtist(String delstreng);
	
	/**
	 * 
	 * @return antall CD-er
	 */
	
	int hentAntall();
	
	/**
	 * Søker og henter antall CD-er med en gitt sjanger
	 * 
	 */
	int hentAntall(Sjanger sjanger);
}