package no.hib.dat102.sorter;

import java.util.List;

public class BubbleSort<T extends Comparable<? super T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		boolean sorted = false;
		int end = list.size() - 1;
		
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < end; i++) {
				if (list.get(i).compareTo(list.get(i + 1)) > 0) {
					swap(list, i, i + 1);
					sorted = false;
				}
			}
			end--;
		}
		
		return list;
	}

	private void swap(List<T> list, int a, int b) {
		T temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
	
}
