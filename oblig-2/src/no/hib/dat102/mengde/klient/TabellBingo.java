package no.hib.dat102.mengde.klient;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.tabell.TabellMengde;

public class TabellBingo extends KlientBingo {

	@Override
	protected MengdeADT<Bingokule> lagNyMengde() {
		return new TabellMengde<Bingokule>();
	}

}
