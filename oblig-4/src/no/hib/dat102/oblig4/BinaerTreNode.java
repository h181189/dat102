package no.hib.dat102.oblig4;

/**
 * Representerer en node i et binaert tre.
 */
public class BinaerTreNode<T> {

	private T element;
	private BinaerTreNode<T> venstre, hoyre;

	public BinaerTreNode(T el) {
		element = el;
		venstre = null;
		hoyre = null;
	}

	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}

	public BinaerTreNode<T> getHoyre() {
		return hoyre;
	}

	public void setVenstre(BinaerTreNode<T> ny) {
		venstre = ny;
	}

	public void setHoyre(BinaerTreNode<T> ny) {
		hoyre = ny;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T el) {
		element = el;
	}

	/**
	 * 
	 * @return antall barn ulik 0
	 */
	public int antallBarn() {
		int barn = 0;

		if (venstre != null)
			barn = 1 + venstre.antallBarn();

		if (hoyre != null)
			barn = barn + 1 + hoyre.antallBarn();

		return barn;
	}
}
