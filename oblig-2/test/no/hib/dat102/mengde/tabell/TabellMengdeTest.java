package no.hib.dat102.mengde.tabell;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.adt.MengdeTest;

public class TabellMengdeTest extends MengdeTest {

	@Override
	protected MengdeADT<Integer> reset() {
		return new TabellMengde<Integer>();
	}
	
	
	
}
