package no.hib.dat102.sorter;

import java.util.List;

public class SelectionSort<T extends Comparable<? super T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		
			for(int i = 0; i < list.size() - 1; i++) {
				T lowest = list.get(i);
				int index = i;
				
				for(int j = i + 1; j < list.size(); j++) {
					if(lowest.compareTo(list.get(j)) > 0) {
						lowest = list.get(j);
						index = j;
					}
				}
				list.set(index, list.get(i));
				list.set(i, lowest);
			}
			
			return list;
	}
}
