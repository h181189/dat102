package no.hib.dat102.mengde.adt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class MengdeTest {
	
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> m3;
	
	private final Integer e1 = 1;
	private final Integer e2 = 2;
	private final Integer e3 = 3;
	private final Integer e4 = 4;
	private final Integer e5 = 5;
	private final Integer e6 = 6;
	
	protected abstract MengdeADT<Integer> reset();
	
	@Before
	public void setup() {
		m1 = reset();
		m2 = reset();
		m3 = reset();
		Assert.assertTrue(m1.erLik(m2));
	}
	
	@Test
	public void testUnionMedFellesElementer() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		
		m3.leggTil(e1);
		m3.leggTil(e2);
		m3.leggTil(e3);
		m3.leggTil(e4);
		m3.leggTil(e5);
		
		Assert.assertTrue(m1.union(m2).erLik(m3));
	}
	
	@Test
	public void testUnionUtenFellesElementer() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		m3.leggTil(e1);
		m3.leggTil(e2);
		m3.leggTil(e3);
		m3.leggTil(e4);
		
		Assert.assertTrue(m1.union(m2).erLik(m3));
	}
	
	@Test
	public void testSnittMedFellesElementer() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		
		m3.leggTil(e3);
		m3.leggTil(e4);
		Assert.assertTrue(m1.snitt(m2).erLik(m3));
	}
	
	@Test
	public void testSnittUtenFellesElementer() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		
		Assert.assertTrue(m1.snitt(m2).erLik(m3));
	}
	
	@Test
	public void testDifferanseMedFellesElementer() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		
		m3.leggTil(e1);
		m3.leggTil(e2);
		
		Assert.assertTrue(m1.differens(m2).erLik(m3));
	}
	
	@Test
	public void testDifferanseUtenFellesElementer() {
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		
		m2.leggTil(e4);
		m2.leggTil(e5);
		m2.leggTil(e6);
		
		m3.leggTil(e1);
		m3.leggTil(e2);
		m3.leggTil(e3);
		
		Assert.assertTrue(m1.differens(m2).erLik(m3));
	}

}
