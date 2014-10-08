package cec.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LibrarySort {

	private static ArrayList<Integer> getRandIntArray(final int size) {
		final Random random = new Random();

		final ArrayList<Integer> array = new ArrayList<Integer>(size);

		for (int i = 0; i < size; i++) {
			array.add(i, new Integer(random.nextInt() % size));
		}

		return array;
	}

	private static void testSortFunc(final ArrayList<Integer> in) {
		final long startTime = System.currentTimeMillis();

		Collections.sort(in);

		final long endTime = System.currentTimeMillis();
		final long elapsedTime = endTime - startTime;

		System.out.format("size: %7d, time: %4d\n", in.size(), elapsedTime);
	}

	public static void main(String[] args) {
		System.out.println("Collections.sort<int>");

		for (int i = 0, j = 50000; i < 40; i++, j += 50000)
			testSortFunc(getRandIntArray(j));
	}

}
