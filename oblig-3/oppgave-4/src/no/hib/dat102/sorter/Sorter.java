package no.hib.dat102.sorter;

import java.util.List;

public interface Sorter<T extends Comparable<? super T>> {
	
	public List<T> sort(List<T> list);
	
}
