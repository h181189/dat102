package no.hib.dat102.sorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> implements Sorter<T> {

	@Override
	public List<T> sort(List<T> list) {
		List<T> sortedList = mergeSort(list);
		list.clear();
		list.addAll(sortedList);
		return list;
	}
	
	private List<T> mergeSort(List<T> list) {
		if (list.size() > 1) {
			int mid = (int) Math.ceil(list.size() / 2);
			
			List<T> firstHalf = mergeSort(list.subList(0, mid));
			List<T> secondHalf = mergeSort(list.subList(mid, list.size()));
			
			list = join(firstHalf, secondHalf);
		}
		
		return list;
	}
	
	private List<T> join(List<T> a, List<T> b) {
		List<T> sortedList = new ArrayList<>(a.size() + b.size());
		int ai = 0, bi = 0;
		while (ai < a.size() && bi < b.size()) {
			sortedList.add(a.get(ai).compareTo(b.get(bi)) < 0 ? a.get(ai++) : b.get(bi++));
		}
		
		if (ai < a.size()) {
			sortedList.addAll(a.subList(ai, a.size()));
		} else if (bi < b.size()) {
			sortedList.addAll(b.subList(bi, b.size()));
		}
		
		return sortedList;
	}
	
}
