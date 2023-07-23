package com.PIMModule;

import org.testng.annotations.AfterMethod;
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

public class TerminationReason {
	private WebDriver driver;
	private Properties properties;
	private String baseUrl;

	
	@BeforeTest
	public void setUp() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream(
					"config_5.properties");
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
	
	@Test(priority = 1)
	public void addTerminationReason() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String configurationDDLocator = properties.getProperty("configuration_dropdown.Locator");
		String terminationOptionLoc = properties.getProperty("termination.Locator");
		String addButtonLoc = properties.getProperty("add_button.Locator");
		String nameTxtboxLoc = properties.getProperty("name_txtbox.Locator");
		String saveButtonLoc = properties.getProperty("save_Button.Locator");
		
		String reasonName = properties.getProperty("terminationReasonName");
		
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
		driver.findElement(By.xpath(terminationOptionLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(addButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(nameTxtboxLoc)).sendKeys(reasonName);
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void updateTerminationReason() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String configurationDDLocator = properties.getProperty("configuration_dropdown.Locator");
		String terminationOptionLoc = properties.getProperty("termination.Locator");
		String updateButtonLoc = properties.getProperty("update_Button.Locator");
		String nameTxtboxLoc = properties.getProperty("name_txtbox.Locator");
		String saveButtonLoc = properties.getProperty("save_Button.Locator");
		
		String reasonName = properties.getProperty("updateTerminationReasonName");
		
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
		driver.findElement(By.xpath(terminationOptionLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(updateButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(nameTxtboxLoc)).sendKeys(reasonName);
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test(priority = 3)
	public void deleteTerminationReason() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String configurationDDLocator = properties.getProperty("configuration_dropdown.Locator");
		String terminationOptionLoc = properties.getProperty("termination.Locator");
		String deleteButtonLoc = properties.getProperty("delete_Button.Locator");
		String deletePopUpLoc = properties.getProperty("confirm_DeletePopup.Locator");
		
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
		driver.findElement(By.xpath(terminationOptionLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(deleteButtonLoc)).click();
		driver.findElement(By.xpath(deletePopUpLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void logOut() {
		// Get locators from properties
		String adminNameDDLoc = properties.getProperty("adminName_DD.Loc");
		String logoutLinkLoc = properties.getProperty("logout_link.Loc");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(adminNameDDLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(logoutLinkLoc)).click();
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
