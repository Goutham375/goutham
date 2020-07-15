package com.hrms.testscripts;

import org.testng.annotations.Test;

public class Example {
	@Test(priority=1)
	public void tc101() {
		System.out.println("tc101 priority=1");
	}
	@Test(priority=2)
	public void tc102() {
		System.out.println("tc102 priority=2)");
	}
	@Test(priority=3)
	public void tc103() {
		System.out.println("tc103 (priority=3");
	}
	@Test(groups="Regression" ,priority=1)
	public void tc104() {
		System.out.println("tc104 groups=\"Regression\" ,priority=1");
	}
	@Test(groups="Regression")
	public void tc105() {
		System.out.println("tc105 groups=\"Regression\"");
	}
	@Test(groups="Sanity",priority=1)
	public void tc106() {
		System.out.println("tc106 groups=\"Sanity\",priority=1");
	}
	@Test(groups="Sanity")
	public void tc107() {
		System.out.println("tc107 groups=\"Sanity\"");
	}
	
	@Test(groups="Functional")
	public void tc108() {
		System.out.println("tc108 groups=\"Functional\"");
	}
	@Test(groups="Functional",priority=1)
	public void tc109() {
		System.out.println("tc109 groups=\"Functional p 1");
	}




}
