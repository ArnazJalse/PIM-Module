package com.PIMModule;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OptionalField {

	private WebDriver driver;
	private Properties properties;
	private String baseUrl;

	
	@BeforeTest
	public void setUp() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream(
					"/Users/arbazjalse/test/arnazWork/PIM_Module/src/test/resources/configs/config_6.properties");
			properties = new Properties();
			try {
				properties.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		baseUrl = properties.getProperty("base.url");
		driver.get(baseUrl);

		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void loginWithValidCredentials() {
		// Get locators from properties
		String userNameTextboxLocator = properties.getProperty("userName_textbox.Locator");
		String passwordTextboxLocator = properties.getProperty("password_textbox.Locator");
		String loginButtonLocator = properties.getProperty("login_button.Locator");

		String userName = properties.getProperty("userName1");
		String password = properties.getProperty("password1");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		driver.findElement(By.name(userNameTextboxLocator)).sendKeys(userName);
		driver.findElement(By.xpath(passwordTextboxLocator)).sendKeys(password);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(loginButtonLocator)).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";

		AssertJUnit.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void optinalFieldToggleTurnOff() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String configurationDDLocator = properties.getProperty("configuration_dropdown.Locator");
		String optionalFieldLoc = properties.getProperty("optionalField_option.Locator");
		String showNickNameToggle = properties.getProperty("showNickName&Smoker_toggle.Locator");
		String showSSNFieldToggle = properties.getProperty("showSSNField_toggle.Locator");
		String showSINFieldToggle = properties.getProperty("showSINField_toggle.Locator");
		String showUSTaxExemptionsmenuToggle = properties.getProperty("showUSTaxExemptionsmenu_toggle.Locator");
		String saveButtonLoc = properties.getProperty("save_Button.Locator");
		
		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configurationDDLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(optionalFieldLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(showNickNameToggle)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(showUSTaxExemptionsmenuToggle)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
