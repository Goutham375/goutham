package com.hrms.lib;

import org.openqa.selenium.WebDriver;

public class Global {
	//global variables
	public WebDriver driver;
	public String url = "http://127.0.0.1/orangehrm-2.6/login.php";
	public String url_title = "OrangeHRM - New Level of HR Management";
	public String logintitle= "OrangeHRM";
	
	//page objects
	
	public String username_identifier = "txtUserName"; //name
	public String password_identifier = "txtPassword"; //name
	public String submit_button = "Submit"; //name
	public String Logout_link = "Logout"; //linktext
	public String WelcomeTextidentifier = "//*[@id=\"option-menu\"]/li[1]"; //xpath
	public String welcometext= "Welcome Goutham_970"; //linktext
	public String frame_add = "rightMenu"; 
	public String add_button = "//*[@id=\"standardView\"]/div[3]/div[1]/input[1]";  //xpath
	public String pim_identifier = "PIM"; // link text
	public String add_employe_link = "Add Employee"; //linktext
	public String firstname_identifier = "txtEmpFirstName"; //name
	public String lastname_identifier = "txtEmpLastName"; //name
	public String Save_button = "btnEdit"; //id
	public String emp_list_link = "Employee List"; //linktext
	public String select_dropdown = "loc_code"; //id
	public String emp_id_identifier_fromdrpdwn = "Emp. ID";// link text
	public String search_bar = "loc_name"; //id
	public String search_button = "//*[@id=\"standardView\"]/div[2]/input[2]"; //xpath
	public String checkbox = "//*[@id=\"standardView\"]/table/tbody/tr/td[1]/input"; //xpath
	public String deletebutton =  "//*[@id=\"standardView\"]/div[3]/div[1]/input[2]"; //xpath
	

 
}//class
