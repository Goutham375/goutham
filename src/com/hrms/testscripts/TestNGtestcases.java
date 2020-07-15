package com.hrms.testscripts;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.lib.General;

public class TestNGtestcases extends General{
	General g = new General();
	
	@BeforeClass
	public void openbrowser() {
		g.OpenApplication();
		System.out.println("before class start: Browser launched");
	}//open
	
	@AfterClass
	public void closeapp() {
		g.CloseApplication();
		System.out.println("after class: Browser closed");

	}//close
	
	@BeforeMethod
	public void loginuser() throws Exception {
		g.implicitlywait();
		g.verifytitle("OrangeHRM - New Level of HR Management");
		g.login("goutham_970", "admin");
		g.verifytitle("OrangeHRM");
		g.verifywelcometext("Welcome Goutham_970");
		System.out.println("before method: login");
	}//login
	@AfterMethod
	public void logoutuser() throws Exception {
		g.logout();
		System.out.println("after method: logout");
	}//logout
	
	@Test(priority=1)
	public void tc101_VerifyLogin() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Reporter.log("logged in");
		g.takescreeenshot("tc101_login");
		System.out.println("tc101 Executed");
	}//tc101
	
	@Test(priority=2)
	public void tc102_Addnewempl() throws Exception {
		g.mouseover_to_pim();
		g.addemp_submenu();
		g.enterframe("rightMenu");
		g.addempdetails("Selinium", "Goutham");
		g.implicitlywait();
		g.exitframe();
		Reporter.log("Employee added");
		g.takescreeenshot("Tc102_Emp added");
		System.out.println("tc102 executed");
	}//add emp
	
	@Test(priority=3)
	public void tc103_deleteemp() throws Exception {
		g.mouseover_to_pim();
		g.emplist_submenu();
		g.enterframe("rightMenu");
		g.delemp("0009");
		g.implicitlywait();
		g.exitframe();
		Reporter.log("Emp deleted");
		g.takescreeenshot("tc103_emp deleted");
		System.out.println("tc103 executed");
	}//del emp
}//class TestNGtestcases

/*OUTPUT
[RemoteTestNG] detected TestNG version 6.8.0
[TestNG] Running:
  C:\Users\nishanth\AppData\Local\Temp\testng-eclipse-1274644959\testng-customsuite.xml

Starting ChromeDriver 83.0.4103.39 (ccbf011cb2d2b19b506d844400483861342c20cd-refs/branch-heads/4103@{#416}) on port 32173
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
Jul 08, 2020 10:12:01 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
Application is opened
before class start: Browser launched
implicitly waited
title matched
title matched
Welcome text matched
Welcome Goutham_970 Logged in
before method: login
tc101 Executed
Logged out
after method: logout
implicitly waited
title matched
title matched
Welcome text matched
Welcome Goutham_970 Logged in
before method: login
Mouse over performed sucessfully
emp added
implicitly waited
tc102 executed
Logged out
after method: logout
implicitly waited
title matched
title matched
Welcome text matched
Welcome Goutham_970 Logged in
before method: login
Mouse over performed sucessfully
tc003 dropdown selected
Emp bearing 0009 deleted
implicitly waited
tc103 executed
Logged out
after method: logout
Application is closed
after class: Browser closed
PASSED: tc101_VerifyLogin
PASSED: tc102_Addnewempl
PASSED: deleteemp

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Failures: 0, Skips: 0
===============================================

[TestNG] Time taken by org.testng.reporters.XMLReporter@3ecf72fd: 16 ms
[TestNG] Time taken by [FailedReporter passed=0 failed=0 skipped=0]: 0 ms
[TestNG] Time taken by org.testng.reporters.EmailableReporter@326de728: 0 ms
[TestNG] Time taken by org.testng.reporters.jq.Main@387c703b: 31 ms
[TestNG] Time taken by org.testng.reporters.SuiteHTMLReporter@3930015a: 22 ms
[TestNG] Time taken by org.testng.reporters.JUnitReportReporter@2cfb4a64: 16 ms
*/