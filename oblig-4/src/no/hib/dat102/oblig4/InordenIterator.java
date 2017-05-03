package no.hib.dat102.oblig4;

import java.util.*;

public class InordenIterator<T> implements Iterator<T> {

	private Stack<BinaerTreNode<T>> s = null;
	private BinaerTreNode<T> aktuell = null;

	public InordenIterator(BinaerTreNode<T> rot) {
		super();
		s = new Stack<BinaerTreNode<T>>();
		aktuell = gaaTilVenstre(rot);
	}

	private BinaerTreNode<T> gaaTilVenstre(BinaerTreNode<T> p) {
		if (p == null)
			return null;
		while (p.getVenstre() != null) {
			s.push(p);
			p = p.getVenstre();
		}
		return p;
	}

	@Override
	public boolean hasNext() {
		return (aktuell != null);
	}

	@Override
	public T next() {
		T resultat = null;

		if (hasNext()) {
			resultat = aktuell.getElement();

			if (aktuell.getHoyre() != null) // har et h�yre undertre
				// stable p� node for venstre undertre
				aktuell = gaaTilVenstre(aktuell.getHoyre());
			else if (!s.isEmpty())
				// ingen h�yre undertre
				aktuell = (BinaerTreNode<T>) s.pop();
			else
				aktuell = null; // slutt p� treet
		}
		return resultat;
	}

	@Override
	public void remove() {

	}

}
