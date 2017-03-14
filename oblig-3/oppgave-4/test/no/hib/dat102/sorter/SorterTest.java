package no.hib.dat102.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class SorterTest {

	private static final int LIST_SIZE = 1000;
	private static final int NUMBER_OF_SORTS = 100;
	
	private List<Integer> list;
	private List<Integer> unsorted;
	
	private Sorter<Integer> sorter;
	
	private final Random random = new Random();
	
	public SorterTest(Sorter<Integer> sorter) {
		this.sorter = sorter;
	}
	
	@Before
	public void setup() {
		list = new ArrayList<>(LIST_SIZE);
		for (int i = 0; i < LIST_SIZE; i++) {
			list.add(random.nextInt(LIST_SIZE));
			Collections.shuffle(list);
		}
		unsorted = new ArrayList<>(list);
	}
	
	@Test
	public void sortMany() {
		for (int i = 0; i < NUMBER_OF_SORTS; i++) {
			sort();
			setup();
		}
	}
	
	@Test
	public void sort() {
		Assert.assertTrue(list.size() == unsorted.size());
		Assert.assertTrue(list.containsAll(unsorted));
		Assert.assertTrue(unsorted.containsAll(list));
		
		Assert.assertFalse(isSorted(list));
		list = sorter.sort(list);
		Assert.assertTrue(isSorted(list));
		
		Assert.assertTrue(list.size() == unsorted.size());
		Assert.assertTrue(list.containsAll(unsorted));
		Assert.assertTrue(unsorted.containsAll(list));
	}
	
	private boolean isSorted(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).compareTo(list.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}
	
}
