package no.hib.dat102.oblig4;

import java.util.Iterator;

public interface BSTreADT<T extends Comparable<T>> extends Iterable<T> {

	/**
	 * 
	 * @return sann hvis dette binaere treet er tomt.
	 */
	public int antall();

	/**
	 * 
	 * @return sant dersom treet er tomt
	 */
	public boolean erTom();

	/**
	 * Legger det spesifiserte elementet paa passende plass i dette binaere
	 * soketreet. Like elementer blir lagt til hogre.
	 * 
	 * @param element
	 */
	public void leggTil(T element);

	/**
	 * 
	 * @return det spesifiserte elementet dersom det finnes, ellers null
	 */
	public T finn(T element);

	/**
	 * Fjerner elementet fra treet hvis det finnes.
	 * 
	 * @return elementet som ble fjernet, ellers null
	 */
	public T fjern(T element);

	/**
	 * 
	 * @return in-orden iterator
	 */
	public Iterator<T> iterator();
}
