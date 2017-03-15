package no.hib.dat102.sorter;

import java.util.List;

public class QuickSort<T extends Comparable<? super T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		return quicksort(list, 0, list.size() - 1);
	}

	private List<T> quicksort(List<T> list, int lo, int hi) {
		if (lo < hi) {
			int p = partition(list, lo, hi);
			quicksort(list, lo, p - 1);
			quicksort(list, p + 1, hi);
		}

		return list;
	}
	
	private int partition(List<T> list, int lo, int hi) {
		T pivot = list.get(hi);
		int i = lo - 1;
		for (int j = lo; j < hi; j++) {
			if (list.get(j).compareTo(pivot) <= 0) {
				i++;
				swap(list, i, j);
			}
		}
		swap(list, i + 1, hi);
		return i + 1;
	}
	
	private void swap(List<T> list, int a, int b) {
		T temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
	
}
