package no.hib.dat102;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TabellStabelTest {

	private TabellStabel<Integer> t1;
	private TabellStabel<Integer> t2;
	
	private final static Integer e1 = 1;
	private final static Integer e2 = 2;
	private final static Integer e3 = 3;
	private final static Integer e4 = 4;
	private final static Integer e5 = 5;
	
	@Before
	public void setup() {
		t1 = new TabellStabel<>();
		t2 = new TabellStabel<>();
	}
	
	@Test
	public void pushElements() {
		Assert.assertTrue(t1.isEmpty());
		
		t1.push(e1);
		Assert.assertFalse(t1.isEmpty());
	}
	
	@Test
	public void popElements() {
		t1.push(e1);
		t1.push(e2);
		t1.push(e3);
		
		Assert.assertEquals(e3, t1.pop());
		Assert.assertEquals(e2, t1.pop());
		Assert.assertEquals(e1, t1.pop());
	}

	@Test
	public void containsElements() {
		t1.push(e1);
		t1.push(e2);
		t1.push(e3);
		
		Assert.assertTrue(t1.inneholder(e2));
		Assert.assertFalse(t1.inneholder(e5));
		
		Assert.assertTrue(t1.inneholder(e3));
		t1.pop();
		Assert.assertFalse(t1.inneholder(e3));
		
	}
	
}
