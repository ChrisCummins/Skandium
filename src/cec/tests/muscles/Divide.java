package cec.tests.muscles;

import java.util.ArrayList;

import cl.niclabs.skandium.muscles.Split;

public class Divide implements Split<ArrayList<Integer>, ArrayList<Integer>> {

	@Override
	public ArrayList<Integer>[] split(final ArrayList<Integer> problem)
			throws Exception {
		final int middle = problem.size() / 2;

		final ArrayList<Integer> left = new ArrayList<Integer>();
		final ArrayList<Integer> right = new ArrayList<Integer>();

		for (int i = 0; i < middle; i++) {
			left.add(problem.get(i));
		}
		for (int i = middle; i < problem.size(); i++) {
			right.add(problem.get(i));
		}

		@SuppressWarnings("unchecked")
		final ArrayList<Integer>[] out = new ArrayList[2];
		out[0] = left;
		out[1] = right;
		return out;
	}

}
