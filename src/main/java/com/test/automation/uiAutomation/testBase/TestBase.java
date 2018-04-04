package com.test.automation.uiAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	public WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browser = "chrome";
	
	public void init() {
		selectBrowser(browser);
		getURL(url);
		String log4jConfigPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
	}
	
	public void selectBrowser(String browserName) {
		
		log.info("creating the object of "+browserName);

		if (System.getProperty("os.name").contains("Win")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				log.info("Opening the chrome browser");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new ChromeDriver();
			}
		}
		
		else if (System.getProperty("os.name").contains("Mac")) {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new ChromeDriver();
			}
		}
		System.out.println(System.getProperty("os.name"));
		
	}
	
	public void getURL(String pageURL) {
		driver.get(pageURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}

