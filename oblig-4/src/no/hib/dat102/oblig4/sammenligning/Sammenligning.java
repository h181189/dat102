package no.hib.dat102.oblig4.sammenligning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sammenligning {
	public static void main(String[] args) {
		 final int size = 1000000;
		 Set<Integer> set = new HashSet<>(size);
		 Integer[] array = new Integer[size];
		
		 int num = 101;
		 final int diff = 501;
		 for (int i = 0; i < size; i++) {
			 num = (num + diff) % size;
			 set.add(num);
			 array[i] = num;
		 }
		 Arrays.sort(array);
		 
		 Random rand = new Random();
		 final int keySize = 10000;
		 Integer[] keys = new Integer[keySize];
		 for (int i = 0; i < keySize; i++) {
			 keys[i] = rand.nextInt(size);
		 }
		 
		 long then = System.currentTimeMillis();
		 
		 for (Integer key : keys) {
			 find(key, array, 0, array.length - 1);
//			 set.contains(key);
		 }
		 
		 long now = System.currentTimeMillis();
		 System.out.println((now - then) + " ms");
		 
	}

	public static boolean find(Integer num, Integer[] array, int start, int end) {
		while (start <= end) {
			int index = start + (end - start) / 2;
			if (num < array[index]) {
				end = index - 1;
			} else if (num > array[index]) {
				start = index + 1;
			} else {
				return true;
			}
		}
		
		return false;
	}

}
