package no.hib.dat102.mengde.kjedet;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.adt.MengdeTest;
import no.hib.dat102.mengde.kjedet.KjedetMengde;

public class KjedetMengdeTest extends MengdeTest {

	@Override
	protected MengdeADT<Integer> reset() {
		return new KjedetMengde<Integer>();
	}
	
}
