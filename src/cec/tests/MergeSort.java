package cec.tests;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Future;

import cec.tests.muscles.Combine;
import cec.tests.muscles.Conquer;
import cec.tests.muscles.Divide;
import cec.tests.muscles.IsDivisible;
import cl.niclabs.skandium.Skandium;
import cl.niclabs.skandium.skeletons.DaC;
import cl.niclabs.skandium.skeletons.Skeleton;

public class MergeSort {

	private static ArrayList<Integer> getRandIntArray(final int size) {
		final Random random = new Random();

		final ArrayList<Integer> array = new ArrayList<Integer>(size);

		for (int i = 0; i < size; i++) {
			array.add(i, new Integer(random.nextInt() % size));
		}

		return array;
	}

	private static void testMergeSortSkeleton(final ArrayList<Integer> in,
			Skeleton<ArrayList<Integer>, ArrayList<Integer>> sort) {
		try {
			final long startTime = System.currentTimeMillis();
			ArrayList<Integer> out;

			Future<ArrayList<Integer>> future = sort.input(in);
			out = future.get();

			final long endTime = System.currentTimeMillis();
			final long elapsedTime = endTime - startTime;
			System.out.format("size: %7d, time: %4d\n", in.size(), elapsedTime);

			for (int i = 0; i < out.size() - 2; i++) {
				if (out.get(i) > out.get(i + 1))
					throw new Exception("Not sorted! " + i + " " + (i + 1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final int threads = 1;

		// Our "muscle" functions:
		final IsDivisible isDivisibleMuscle = new IsDivisible(100);
		final Divide divideMuscle = new Divide();
		final Conquer conquerMuscle = new Conquer();
		final Combine combineMuscle = new Combine();

		// Our skeleton instance:
		final Skeleton<ArrayList<Integer>, ArrayList<Integer>> sort = new DaC<ArrayList<Integer>, ArrayList<Integer>>(
				isDivisibleMuscle, divideMuscle, conquerMuscle, combineMuscle);

		final Skandium skandium = new Skandium(threads);

		System.out.println("Skandium.MergeSort<int>, threads: " + threads);

		for (int i = 0, j = 50000; i < 40; i++, j += 50000)
			testMergeSortSkeleton(getRandIntArray(j), sort);

		skandium.shutdown();
	}

}
