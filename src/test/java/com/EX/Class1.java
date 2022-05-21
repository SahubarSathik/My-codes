package com.EX;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {
	@Test(groups =  "@vivo",dependsOnGroups= "@realme")
	public void testCase01() {
		System.out.println("vivo");
	}

	@Test(groups =  "@vivo" ,dependsOnGroups= "@realme")
	public void testCase02() {
		System.out.println("vivo");
	}

	@Test(groups =  "@realme" )
	public void testCase03() {
		Assert.assertTrue(false);
		System.out.println("realme");
	}

	@Test(groups =  "@realme")
	public void textCase04() {
		System.out.println("realme");
	}

	@Test(groups =  "@samsung" ,dependsOnGroups= "@azus")
	public void textCase05() {
		System.out.println("samsung");
	}

	@Test(groups =  "@samsung" ,dependsOnGroups= "@azus")
	public void textCase06() {
		System.out.println("samsung");
	}

	@Test(groups = "@azus")
	public void textCase07() {
		System.out.println("azus");

	}

	@Test(groups = "@azus")
	public void textCase08() {
		System.out.println("azus");
	}
}
