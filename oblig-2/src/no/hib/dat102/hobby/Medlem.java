package no.hib.dat102.hobby;

import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {

	private static int STATUS_INDEKS_LEDIG = -1;
	
	private String navn;
	private KjedetMengde<Hobby> hobbyer = new KjedetMengde<>();
	private int statusIndeks = STATUS_INDEKS_LEDIG;
	
	public Medlem(String navn) {
		this.navn = navn;
	}
	
	/**
	 * 
	 * @return medlemnavn
	 */
	public String getNavn() {
		return navn;
	}
	
	/**
	 * Setter navn til medlemmet
	 * 
	 * @param navn
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	/**
	 * 
	 * @return statusIndeks
	 */
	public int getStatusIndeks() {
		return statusIndeks;
	}
	
	/**
	 * Setter statusindeks.
	 *  
	 * @param statusIndeks
	 */
	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	/**
	 * Nullstiller statusindeks.
	 */
	public void nullstillStatusIndeks() {
		setStatusIndeks(STATUS_INDEKS_LEDIG);
	}
	
	/**
	 * Legger til hobby
	 * 
	 * @param navn
	 */
	public void leggTilHobby(String navn) {
		hobbyer.leggTil(new Hobby(navn));
	}
	
	/**
	 * 
	 * @return hobbyer i en kjedetstruktur
	 */
	public KjedetMengde<Hobby> getHobbyer() {
		return hobbyer;
	}
	
	/**
	 * Sjekker om gitt argument er ledig eller er samme objekt.
	 * Hvis ingen av delene, sjekker den om de har like hobbyer. 
	 * 
	 * @param m2
	 * @return om medlemmet passer til gitt argument
	 */
	public boolean passerTil(Medlem m2) {
		if (this.equals(m2)) {
			return false;
		}
		if (getStatusIndeks() != -1) {
			return false;
		}
		if (m2.getStatusIndeks() != -1) {
			return false;
		}
		return hobbyer.erLik(m2.getHobbyer());
	}
	
}
