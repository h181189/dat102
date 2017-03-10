package no.hib.dat102.liste.kjedet;

import no.hib.dat102.liste.adt.OrdnetListeADT;

/**
 * Kjedet ordnet liste.
 *
 * @param <T>
 *            elementtypen
 */

public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
    private LinearNode<T> foerste, siste;

    /**
     * Lager en ny tom liste.
     */
    public KjedetOrdnetListe() {
        antall = 0;
        foerste = null;
        siste = null;
    }

		
	@Override
	public void leggTil(T element) {
		LinearNode<T> ny = new LinearNode<T>(element);
		LinearNode<T> denne = foerste, forrige = null;
		
		if (foerste == null) {
			foerste = siste = ny;
		} else {
			
			boolean fortsett = denne.getElement().compareTo(element) < 0;
			while (denne.getNeste() != null && fortsett) {
				forrige = denne;
				denne = denne.getNeste();
				fortsett = denne.getElement().compareTo(element) < 0;
			}
			
			if (fortsett) {
				denne.setNeste(ny);
				siste = ny;
			} else {
				if (forrige == null) {
					foerste = ny;
				} else {
					forrige.setNeste(ny);
				}
				ny.setNeste(denne);
			}
		}
		
		antall++;
	}

	
	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}


	@Override
    public T foerste() {
        T svar = null;
        if (!erTom()) {
            svar = foerste.getElement();
        }
        return svar;
    }


    @Override
    public T siste() {
        T svar = null;
        if (!erTom()) {
            svar = siste.getElement();
        }
        return svar;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public T fjernFoerste() {
        return fjern(foerste.getElement());
    }

    @Override
    public T fjernSiste() {
        return fjern(siste.getElement());
    }
	
	
    @Override
    public String toString() {
    	LinearNode<T> node = foerste;
    	String string = "";
    	string += node.getElement().toString() + " ";
    	while (node.getNeste() != null) {
    		node = node.getNeste();
    		string += node.getElement().toString() + " ";
    	}
    	
    	return string;
    }
    
}
