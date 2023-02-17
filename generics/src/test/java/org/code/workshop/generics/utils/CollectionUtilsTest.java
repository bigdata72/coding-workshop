package org.code.workshop.generics.utils;


import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionUtilsTest {
	
	@Test
	void max () {
		List<Long> numbers = new ArrayList<>();
		numbers.add(1L);
		numbers.add(2L);
		numbers.add(3L);
		numbers.add(4L);
		numbers.add(3L);
		assertThat(CollectionUtils.max(numbers)).isEqualTo(4L);
	}
	
	@Test
	void max_with_nulls () {
		List<Long> numbers = new ArrayList<>();
		numbers.add(null); // multiple nulls at head then valid element and multiple nulls
		numbers.add(null);
		numbers.add(null);
		numbers.add(2L);
		numbers.add(null);
		numbers.add(null);
		numbers.add(3L);
		assertThat(CollectionUtils.max(numbers)).isEqualTo(3L);
	}
	
	@Test
	void max_only_nulls () {
		List<Long> numbers = new ArrayList<>();
		numbers.add(null);
		assertThat(CollectionUtils.max(numbers)).isNull();
	}
}