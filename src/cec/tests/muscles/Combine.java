package cec.tests.muscles;

import java.util.ArrayList;

import cl.niclabs.skandium.muscles.Merge;

public class Combine implements Merge<ArrayList<Integer>, ArrayList<Integer>> {

	@Override
	public ArrayList<Integer> merge(ArrayList<Integer>[] problems)
			throws Exception {
		
		final ArrayList<Integer> left = problems[0];
		final ArrayList<Integer> right = problems[1];
		final ArrayList<Integer> out = new ArrayList<Integer>();
		
		int l = 0, r = 0;
		
		while (l < left.size() && r < right.size()) {
			if (right.get(r) < left.get(l))
				out.add(right.get(r++));
			else
				out.add(left.get(l++));
		}

		while (r < right.size())
			out.add(right.get(r++));
		
		while (l < left.size())
			out.add(left.get(l++));
		
		return out;
	}

}
