package cec.tests.muscles;

import java.util.ArrayList;

import cl.niclabs.skandium.muscles.Condition;

public class IsDivisible implements Condition<ArrayList<Integer>> {

	private final int minProblemSize;

	public IsDivisible(final int minProblemSize) {
		this.minProblemSize = minProblemSize;
	}

	@Override
	public boolean condition(final ArrayList<Integer> problem) throws Exception {
		return problem.size() > this.minProblemSize;
	}

}
