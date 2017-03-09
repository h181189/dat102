package no.hib.dat102.mengde.klient;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class KjedetBingo extends KlientBingo {

	@Override
	protected MengdeADT<Bingokule> lagNyMengde() {
		return new KjedetMengde<Bingokule>();
	}

}
