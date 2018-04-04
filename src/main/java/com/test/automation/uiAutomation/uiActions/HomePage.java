package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath = "//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath = "//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath = "//*[@id='center_column']/div[1]/ol/li")
	WebElement authFailedMessage;
	
	/*
	 * if we do not create the constructor with the passing of webdriver object, then it gives the NullPointerException
	 * because when we get to this HomePage.class file, here webdriver object holds the Null value and doesn't know 
	 * where to redirect.   
	 */
	public HomePage(WebDriver driver) {	
		PageFactory.initElements(driver, this);//'this' means it refers to the current class object.
	}
	
	public void loginToApp(String email, String password) {
		
		signIn.click();
		log.info("Clicked on signIn and object is: "+signIn.toString());
		
		loginEmailAddress.sendKeys(email);
		log.info("Email address is: "+email+" and object is: "+ loginEmailAddress.toString());
		
		loginPassword.sendKeys(password);
		log.info("Password is: "+password+" and object is: "+loginPassword.toString());
		
		submitButton.click();
		log.info("Clicked on submit button and the object is: "+submitButton.toString());
	}
	
	public String invalidAuthMsg() {
		log.info("Retrieving the error message: "+ authFailedMessage.getText());
		return authFailedMessage.getText();
	}
	
	
}
