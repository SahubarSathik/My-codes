package com.EX;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class Class2 {
	@Test(invocationCount=5,threadPoolSize=5)
	public void tr201() {
		System.out.println("tr201");
	}
	@Test(description="test is for maximum index")
	public void tr202() {
		System.out.println("tr202");
		throw new NoSuchElementException();
		
	}
	@Test(dependsOnMethods="com.EX.Class2.tr202",alwaysRun = true)
	public void tr203() {
		System.out.println("tr202");
	}
}
