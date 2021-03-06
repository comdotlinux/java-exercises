package com.linux.test.equalshascodetest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

public class EqualsHashCodeTest {

	@Test
	public void test_List_indexOf_object_without_hashcode() {
		List<A> aList = new ArrayList<>();
		aList.add(new A(1));
		aList.add(new A(2));
		aList.add(new A(3));
		aList.add(new A(4));
		aList.add(new A(5));
		
		A three = new A(3);
		
		assertThat(aList.indexOf(three), is(equalTo(2)));
		
	}

	@Test
	public void test_Set_indexOf_object_without_hashcode() {
		Set<A> aSet = new HashSet<>();
		aSet.add(new A(1));
		aSet.add(new A(2));
		aSet.add(new A(3));
		aSet.add(new A(4));
		aSet.add(new A(5));
		
		A three = new A(3);
		
		assertThat(aSet,hasItem(three)); // This returns true!!! Why?
		assertThat(aSet.contains(three), is(false));
		
	}
	
	@Test
	public void test_List_indexOf_object_with_hashcode() {
		List<B> bList = new ArrayList<>();
		bList.add(new B(1));
		bList.add(new B(2));
		bList.add(new B(3));
		bList.add(new B(4));
		bList.add(new B(5));
		
		B three = new B(3);
		
		assertThat(2, is(equalTo(bList.indexOf(three))));
		
	}

	@Test
	public void test_Set_indexOf_object_with_hashcode() {
		Set<B> bSet = new HashSet<>();
		bSet.add(new B(1));
		bSet.add(new B(2));
		bSet.add(new B(3));
		bSet.add(new B(4));
		bSet.add(new B(5));
		
		B three = new B(3);
		
		assertTrue(bSet.contains(three));
		
	}
	
}
