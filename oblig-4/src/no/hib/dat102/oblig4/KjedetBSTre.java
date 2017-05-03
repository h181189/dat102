package no.hib.dat102.oblig4;

import java.util.*;

class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T>, Iterable<T> {

	private int antall;
	private BinaerTreNode<T> rot;

	/**
	 * Oppretter et tomt soketre.
	 */
	public KjedetBSTre() {
		antall = 0;
		rot = null;
	}

	/**
	 * Oppretter binaert soketre med én node. 
	 */
	public KjedetBSTre(T element) {
		antall = 1;
		rot = new BinaerTreNode<T>(element);
	}

	/**
	 * 
	 * @return antall noder i treet som ikke er null
	 */
	public int antall() {
		return antall;
	}

	/**
	 * 
	 * @return om treet er tomt
	 */
	public boolean erTom() {
		return (antall == 0);
	}

	/**
	 * Legger det spesifiserte elementet paa passende plass i treet ved hjelp av rekursjon. Like
	 * elementer blir lagt til hoyre.
	 */
	public void leggTil(T element) {
		rot = leggTilRek(rot, element);
		antall++;
	}

	private BinaerTreNode<T> leggTilRek(BinaerTreNode<T> p, T element) {
		if (p == null) { // Tomt (under-)tre, lag node
			BinaerTreNode<T> ny = new BinaerTreNode<T>(element);
			return ny;
		} else if (element.compareTo(p.getElement()) < 0) {
			p.setVenstre(leggTilRek(p.getVenstre(), element));
			return p;
		} else {
			p.setHoyre(leggTilRek(p.getHoyre(), element)); // Ev. like til h�gre
			return p;
		}
	}

	/**
	 * Legger det spesifiserte elementet paa passende plass i treet uten rekursjon. Like
	 * elementer blir lagt til hoyre.
	 */
	public void leggTil2(T element) {
		BinaerTreNode<T> temp = new BinaerTreNode<T>(element);
		if (erTom())
			rot = temp;
		else {
			BinaerTreNode<T> aktuell = rot;
			boolean lagtTil = false;

			while (!lagtTil) {
				if (element.compareTo(aktuell.getElement()) < 0) {
					if (aktuell.getVenstre() == null) {
						aktuell.setVenstre(temp);
						lagtTil = true;
					} else
						aktuell = aktuell.getVenstre();
				} // if
				else { // >=
					if (aktuell.getHoyre() == null) {
						aktuell.setHoyre(temp);
						;
						lagtTil = true;
					} else
						aktuell = aktuell.getHoyre();
				} // else

			} // while
		}

		antall++;
	}

	/**
	 * Fjerner elementet med minst verdi i treet
	 * 
	 * @return elementet med minste verdi i treet som ble fjernet
	 */
	public T fjernMin() {
		T resultat = null;

		if (!erTom()) {
			if (rot.getVenstre() == null) {
				resultat = rot.getElement();
				rot = rot.getHoyre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getVenstre();
				while (aktuell.getVenstre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getVenstre();
				}
				resultat = aktuell.getElement();
				foreldre.setVenstre(aktuell.getHoyre());
			}

			antall--;
		}

		return resultat;
	}

	/**
	 * Fjerner det storste elemenetet i treet
	 * 
	 * @return storste elementet i treet
	 */
	public T fjernMaks() {
		T resultat = null;

		if (!erTom()) {

			if (rot.getHoyre() == null) {
				resultat = rot.getElement();
				rot = rot.getVenstre();
			} else {
				BinaerTreNode<T> foreldre = rot;
				BinaerTreNode<T> aktuell = rot.getHoyre();
				while (aktuell.getHoyre() != null) {
					foreldre = aktuell;
					aktuell = aktuell.getHoyre();
				}

				resultat = aktuell.getElement();
				foreldre.setHoyre(aktuell.getVenstre());
			}

			antall--;
		}

		return resultat;
	}

	/**
	 * 
	 * @return minste elementet i treet
	 */
	public T finnMin() {

		T resultat = null;

		if (!erTom()) {
			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getVenstre() != null)
				aktuell = aktuell.getVenstre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}

	/**
	 * 
	 * @return storste elementet i treet
	 */
	public T finnMaks() {
		T resultat = null;

		if (!erTom()) {

			BinaerTreNode<T> aktuell = rot;

			while (aktuell.getHoyre() != null)
				aktuell = aktuell.getHoyre();

			resultat = aktuell.getElement();
		}

		return resultat;
	}

	/**
	 * Finner det spesifiserte elementet i treet ved bruk av rekursjon.
	 * 
	 * @return spesifiserte elementet dersmo det finnes i treet
	 */
	public T finn(T element) {
		return finnRek(element, rot);
	}

	private T finnRek(T element, BinaerTreNode<T> p) {
		T svar = null;
		if (p != null) {
			if (element.compareTo(p.getElement()) == 0) { // I rot
				svar = p.getElement();
			} else if (element.compareTo(p.getElement()) < 0) {
				svar = finnRek(element, p.getVenstre()); // I venstre u.t.
			} else {
				svar = finnRek(element, p.getHoyre()); // I h�gre u.t.
			}
		}
		return svar;
	}

	/**
	 * Finner elementet i treet uten bruk av rekursjon.
	 * 
	 * @return spesifiserte elementet dersmo det finnes i treet
	 */
	public T finn2(T element) {
		// S�k med while-setning

		BinaerTreNode<T> p = rot;
		T svar = null;
		while (p != null && svar == null) {
			if (element.compareTo(p.getElement()) < 0)
				p = p.getVenstre();
			else if (element.compareTo(p.getElement()) > 0)
				p = p.getHoyre();
			else
				svar = p.getElement();
		}
		return svar;
	}

	/**
	 * 
	 * @return in-orden iterator
	 */
	public Iterator<T> iterator() {
		return new InordenIterator<T>(rot);
	}

	/**
	 * Gjennomgaar treet i preorden.
	 */
	public void visPreorden() {
		visRekPreorden(rot);
		System.out.println();
	}

	private void visRekPreorden(BinaerTreNode<T> p) {
		if (p != null) {
			System.out.print(p.getElement() + " ");
			visRekPreorden(p.getVenstre());
			visRekPreorden(p.getHoyre());
		}
	}

	/**
	 * Gjennomgaar treet i orden.
	 */
	public void visInorden() {
		visRekInorden(rot);
		System.out.println();
	}

	private void visRekInorden(BinaerTreNode<T> p) {
		if (p != null) {
			visRekInorden(p.getVenstre());
			System.out.print(p.getElement() + " ");
			visRekInorden(p.getHoyre());
		}
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @return hoyden av treet
	 */
	public int finnHoyde() {
		return finnHoyde(rot);
	}
	
	private int finnHoyde(BinaerTreNode<T> parent) {
		int venstre = 0, hoyre = 0;
		if (parent.getVenstre() != null) {
			venstre = finnHoyde(parent.getVenstre()) + 1;
		}
		if (parent.getHoyre() != null) {
			hoyre = finnHoyde(parent.getHoyre()) + 1;
		}
		return Math.max(venstre, hoyre);
	}
	
}
