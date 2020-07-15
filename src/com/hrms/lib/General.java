package com.hrms.lib;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.utility.Log;

public class General extends Global {

		public void OpenApplication() {
			Log.info("Started execution");
			System.setProperty("webdriver.chrome.driver", "D:\\Goutham's folder\\selinium files and eclipse\\drivers\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(url);
			Log.info("Opened application");
			driver.manage().window().maximize();
			System.out.println("Application is opened");			
		}//openapp
		public void CloseApplication() {
			driver.quit();
			System.out.println("Application is closed");
			Log.info("End application");
		}//closeapp
		public void login(String username, String password) throws Exception { // pass username and password values as parameters
			
			driver.findElement(By.name(username_identifier)).sendKeys(username);
			driver.findElement(By.name(password_identifier)).sendKeys(password);
			driver.findElement(By.name(submit_button)).click();
			/*assertTrue(driver.getTitle().matches(logintitle));
			System.out.println("Title matched ");*/
			
		}//login 
		public void logout() throws Exception {
			driver.findElement(By.linkText(Logout_link)).click();
			System.out.println("Logged out");
			Thread.sleep(2000);
		}//logout
		
		
		public void explicit_wait(String elementtobeclickable) { 
			WebDriverWait wait = new WebDriverWait(driver, 9);
			wait.until(ExpectedConditions.elementToBeClickable(By.name(elementtobeclickable)));
			System.out.println("wait command added");
		}//expwait
		
		public void implicitlywait() {
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			System.out.println("implicitly waited");
		}//imp wait
		public void verifytitle(String title) {
			if(driver.getTitle().matches(title)){
				System.out.println("title matched");
			}
			else 
				System.out.println("title missmatched" + driver.getTitle());
		}//verifytitle
		public void verifywelcometext(String welcometext) throws Exception {
			assertTrue(driver.findElement(By.xpath(WelcomeTextidentifier)).getText().matches(welcometext));
			System.out.println("Welcome text matched");
			System.out.println(welcometext + " Logged in");
			Thread.sleep(3000);
		}//welcometext
		
		public void enterframe(String frameid) {
			driver.switchTo().frame(frameid);
		}//enterframe
		
		public void exitframe() throws Exception {
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}//exitframe
		public void mouseover_to_pim() {
			Actions act = new Actions(driver);
			WebElement pim = driver.findElement(By.linkText(pim_identifier));
			act.moveToElement(pim).perform();
			System.out.println("Mouse over performed sucessfully");
		}//pim
		
		public void addemp_submenu() throws Exception {
			driver.findElement(By.linkText(add_employe_link)).click(); 
			Thread.sleep(4000);
			
		}//addemp_link
		
		public void addempdetails(String lastname, String firstname) throws Exception {
			driver.findElement(By.name(lastname_identifier)).sendKeys(lastname);
			Thread.sleep(4000);
			driver.findElement(By.name(firstname_identifier)).sendKeys(firstname);
			Thread.sleep(3000);
			driver.findElement(By.id(Save_button)).click();
			Thread.sleep(3000);
			System.out.println("emp added");
		}//addempdetails
		public void emplist_submenu() {
			driver.findElement(By.linkText(emp_list_link)).click();
		}//emp list
		
		public void delemp(String empid) throws Exception {
			Select dropdown = new Select(driver.findElement(By.id(select_dropdown)));//object for dropdown
			dropdown.selectByVisibleText(emp_id_identifier_fromdrpdwn);
			System.out.println("tc003 dropdown selected");
			driver.findElement(By.id(search_bar)).sendKeys(empid);
			driver.findElement(By.xpath(search_button)).click();
			driver.findElement(By.xpath(checkbox)).click();
			driver.findElement(By.xpath(deletebutton)).click();
			System.out.println("Emp bearing " + empid + " deleted");
		}//delemp
		public void takescreeenshot(String ssname) throws Exception {
			File fi = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(fi, new File("D:\\Goutham's folder\\MagneQ_software_testing_course\\MagneQ_workspace for selinium programs\\screenshots\\" + ssname+ ".png"));		
		}//screenshot
		
}//class general
