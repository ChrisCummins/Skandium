package cec.tests.muscles;

import java.util.ArrayList;

import cl.niclabs.skandium.muscles.Execute;

public class Conquer implements Execute<ArrayList<Integer>, ArrayList<Integer>> {

	@Override
	public ArrayList<Integer> execute(final ArrayList<Integer> problem)
			throws Exception {

		int key, j;

		for (int i = 1; i < problem.size(); i++) {
			key = problem.get(i);
			j = i;

			while (j > 0 && problem.get(j - 1) > key) {
				problem.set(j, problem.get(j - 1));
				j--;
			}

			problem.set(j, key);
		}

		return problem;
	}

}
