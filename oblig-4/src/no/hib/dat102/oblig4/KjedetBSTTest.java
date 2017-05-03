package no.hib.dat102.oblig4;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KjedetBSTTest {

	private KjedetBSTre<Integer> bs;

	// Testdata som legges inn i treet
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;

	// Data som ikke legges inn i treet
	private Integer e7 = 8;

	/**
	 * Opprett en tomt tre for hver test.
	 */
	@Before
	public final void setup() throws Exception {
		bs = new KjedetBSTre<Integer>();
	}

	/**
	 * Tester finn
	 *
	 * Her legger du inn e0...e6 i treet i en vilk�rlig rekkef�lge. Etterp�
	 * sjekker du om elementene fins og til slutt sjekker du at e7 ikke fins
	 */
	@Test
	public final void erElementIBSTre() {
		bs.leggTil(e0);
		bs.leggTil(e1);
		bs.leggTil(e2);
		bs.leggTil(e3);
		bs.leggTil(e4);
		bs.leggTil(e5);
		bs.leggTil(e6);
		
		Assert.assertEquals(e0, bs.finn(e0));
		Assert.assertEquals(e2, bs.finn(e2));
		Assert.assertEquals(e1, bs.finn(e1));
		Assert.assertEquals(e4, bs.finn(e4));
		Assert.assertEquals(e5, bs.finn(e5));
		Assert.assertEquals(e3, bs.finn(e3));
		Assert.assertEquals(e6, bs.finn(e6));
		
		Assert.assertNotEquals(e7, bs.finn(e7));
	}

	/**
	 * Tester ordning ved � legge til elementer og fjerne minste
	 */
	@Test
	public final void erBSTreOrdnet() {
		bs.leggTil(e0);
		bs.leggTil(e1);
		bs.leggTil(e2);
		bs.leggTil(e3);
		bs.leggTil(e4);
		bs.leggTil(e5);
		bs.leggTil(e6);
		
		Assert.assertEquals(e0, bs.fjernMin());
		Assert.assertEquals(e1, bs.fjernMin());
		Assert.assertEquals(e2, bs.fjernMin());
		Assert.assertEquals(e3, bs.fjernMin());
		Assert.assertEquals(e4, bs.fjernMin());
		Assert.assertEquals(e5, bs.fjernMin());
		Assert.assertEquals(e6, bs.fjernMin());
	}

	/**
	 * 1. Her legge du f�rst inn e0...e6 i en vilk�rlig rekkef�lge og s� fjerne
	 * du minste hele tiden.
	 * 
	 * 2. Tester ordning ved � bruke en inordeniterator Her studerer du alt om
	 * bruk av inordeniterator.
	 */
	@Test
	public final void erBSTreOrdnet2() {
		bs.leggTil(e3);
		bs.leggTil(e2);
		bs.leggTil(e4);
		bs.leggTil(e1);
		bs.leggTil(e5);
		bs.leggTil(e0);
		bs.leggTil(e6);

		Integer[] el = { e0, e1, e2, e3, e4, e5, e6 };
		int i = 0;
		for (Integer e : bs) {
			Assert.assertEquals(el[i], e);
			i++;
		}
		
		Iterator<Integer> it = bs.iterator();
		for (Integer e : el) {
			Assert.assertEquals(e, it.next());
		}
	}

}
