package org.code.workshop.generics.wildcard;

import java.util.*;

public class Extend {
	public static void main (String[] args) {
		Collection<Number> numColl = Collections.emptyList();
		Collection<? extends Number> extColl = Collections.emptyList();
		
		List<Number> nums = Arrays.asList(1, 2, 3.14);
		List<Integer> ints = new ArrayList<>();
		
		// List<Number> is a subtype of Collection<Number>
		// numColl = nums;  // is ok, Substitution principle
		
		// List<Integer> is NOT a subtype of Collection<Number>
		// numColl = ints; // compile error
		
		// List<Integer> is not a subtype of List<Number>
		//nums = ints; // compile error
		
		// List<Integer> is a subtype of Collection<? extends Number>
		// extColl = ints; // is ok, Substitution principle
		
		// List<Number> is a subtype of Collection<? extends Number>
		// extColl = nums; // is ok, Substitution principle
		
	}
}
