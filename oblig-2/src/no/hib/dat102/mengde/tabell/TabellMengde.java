package no.hib.dat102.mengde.tabell;

import no.hib.dat102.mengde.adt.*;
import java.util.Iterator;
import java.util.Random;

public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		T svar = null;
		if (antall > 0) {
			int indeks = tilf.nextInt(antall);
			svar = tab[indeks];
			tab[indeks] = tab[antall - 1];
			antall--;
		}
		return svar;
	}

	@Override
	public T fjern(T element) {
		// Soker etter og fjerner element.Retur med null ved ikke-funn
		//
		boolean funnet = false;
		T svar = null;
		if (erTom()) {
			return svar;
		}
		for (int i = 0; i < antall && !funnet; i++) {
			if (element.equals(tab[i])) {
				svar = tab[i];
				funnet = true;
				tab[i] = tab[antall - 1];
				antall--;
			}
		}
		return svar;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			begge.leggTil(tab[i]);
		}
		Iterator<T> teller = m2.oppramser();

		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}

		return begge;
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}

	@Override
	public boolean inneholder(T element) {
		int pos = -1;
		for (int i = 0; (i < antall) && (pos == -1); i++) {
			if (tab[i].equals(element))
				pos = i;
		}
		return (pos != -1);
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		if (m2.antall() != antall()) {
			return false;
		}
		boolean likeMengder = true;
		for (int i = 0; i < antall() && likeMengder; i++) {
			likeMengder = m2.inneholder(tab[i]);
		}
		return likeMengder;
	}

	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public Iterator<T> oppramser() {
		return new TabellIterator<T>(tab, antall);
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> felles = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			if (m2.inneholder(tab[i])) {
				felles.leggTil(tab[i]);
			}
		}
		return felles;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> dif = new TabellMengde<T>();
		for (int i = 0; i < antall; i++) {
			if (!m2.inneholder(tab[i])) {
				dif.leggTil(tab[i]);
			}
		}
		Iterator<T> it = m2.oppramser();
		while (it.hasNext()) {
			T t = it.next();
			if (!inneholder(t)) {
				dif.leggTil(t);
			}
		}
		return dif;		
	}

}// class
