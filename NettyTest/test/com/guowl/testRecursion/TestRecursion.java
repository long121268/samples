package com.guowl.testRecursion;

import org.junit.Test;

public class TestRecursion {
	private static int i = 0;
	
	@Test
	public void test(){
		if (i < 5) {
			i++;
			test();
		} else {
			print();
		}
	}
	private void print(){
		System.out.println(i);
	}
}
