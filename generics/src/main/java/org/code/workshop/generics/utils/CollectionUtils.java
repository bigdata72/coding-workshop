package org.code.workshop.generics.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class CollectionUtils {
	/* generic method to determine the max element */
	public static <T extends Comparable<T>> T max(Collection<T> cs){
		T max = null;
		if(!cs.isEmpty()){
			Iterator<T> iter = cs.iterator();
			if(iter.hasNext()) {
				max = iter.next();
				while(iter.hasNext()){
					T elem = iter.next();
					if(Objects.nonNull(max) && Objects.nonNull(elem) && (elem.compareTo(max) > 0)) {
						max = elem;
					}else if(Objects.isNull(max) && Objects.nonNull(elem)) {
						max = elem;
					}
				}
			}
		}
		return max;
	}
}
