package com.rhcloud.test.equalshascodetest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.Test;

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
		
		assertThat(2, is(equalTo(aList.indexOf(three))));
		
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
		assertTrue("three is not found in aSet", aSet.contains(three));
		
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
		
		assertTrue("three is not found in aSet", bSet.contains(three));
		
	}
	
	class A{
		private final int varA;

		A(int varA){
			this.varA = varA;
		}
		
		public int getVarA() {
			return varA;
		}

		@Override
		public boolean equals(Object o){
			if(this == o)
				return true;
			else if(null == o || this.getClass() != o.getClass())
				return false;
		
			A a = (A) o;
			return a.varA == varA;
		}
	}
	
	class B{
		private final int varB;

		B(int varA){
			this.varB = varA;
		}
		
		public int getVarA() {
			return varB;
		}

		@Override
		public boolean equals(Object o){
			if(this == o)
				return true;
			else if(null == o || this.getClass() != o.getClass())
				return false;
		
			B a = (B) o;
			return a.varB == varB;
		}
		
		@Override
		public int hashCode() {
			return Objects.hashCode(this);
		}
	}
	
}
