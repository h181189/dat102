package no.hib.dat102.sorter;

import java.util.List;

public class InsertionSort<T extends Comparable<? super T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		
		for(int i = 0; i < list.size(); i++) {
			T element = list.get(i);
			int j = i;
			
			while(j > 0 && element.compareTo(list.get(j - 1)) < 0) {
				list.set(j, list.get(j-1));
				j--;
			}
			list.set(j, element);
		}
		
		return list;
	}

}
