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
	private Sorter<Integer> sorter;
	
	private final Random random = new Random();
	
	public SorterTest(Sorter<Integer> sorter) {
		this.sorter = sorter;
	}
	
	@Before
	public void setup() {
		this.list = new ArrayList<>(LIST_SIZE);
		for (int i = 0; i < LIST_SIZE; i++) {
			list.add(random.nextInt(LIST_SIZE));
		}
	}
	
	@Test
	public void sortMany() {
		for (int i = 0; i < NUMBER_OF_SORTS; i++) {
			sort();
			Collections.shuffle(list);
		}
	}
	
	@Test
	public void sort() {
		Assert.assertFalse(isSorted(list));
		sorter.sort(list);
		Assert.assertTrue(isSorted(list));
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
