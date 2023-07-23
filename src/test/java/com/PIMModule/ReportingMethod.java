package com.PIMModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportingMethod {
	private WebDriver driver;
	private Properties properties;
	private String baseUrl;

	@BeforeTest
	public void setUp() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream(
					"/Users/arbazjalse/test/arnazWork/PIM_Module/src/test/resources/configs/config_8.properties");
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
	public void addReportingMethod() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String configurationDDLocator = properties.getProperty("configuration_dropdown.Locator");
		String reportingMethodLoc = properties.getProperty("reportingMethod.Locator");
		String addButtonLoc = properties.getProperty("add_Button.Locator");
		String nameTxtBoxLoc = properties.getProperty("name_txtBox.Locator");
		String saveButtonLoc = properties.getProperty("save_Button.Locator");

		String name = properties.getProperty("name");

		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configurationDDLocator)).click();
		driver.findElement(By.xpath(reportingMethodLoc)).click();
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
		driver.findElement(By.xpath(nameTxtBoxLoc)).sendKeys(name);
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test(priority = 2)
	public void updateReportingMethod() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String configurationDDLocator = properties.getProperty("configuration_dropdown.Locator");
		String reportingMethodLoc = properties.getProperty("reportingMethod.Locator");
		String updateButtonLoc = properties.getProperty("update_Button.locator");
		String nameTxtBoxLoc = properties.getProperty("name_txtBox.Locator");
		String saveButtonLoc = properties.getProperty("save_Button.Locator");

		String updateName = properties.getProperty("updated_name");

		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configurationDDLocator)).click();
		driver.findElement(By.xpath(reportingMethodLoc)).click();
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
		driver.findElement(By.xpath(nameTxtBoxLoc)).clear();
		driver.findElement(By.xpath(nameTxtBoxLoc)).sendKeys(updateName);
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void deleteReportingMethod() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String configurationDDLocator = properties.getProperty("configuration_dropdown.Locator");
		String reportingMethodLoc = properties.getProperty("reportingMethod.Locator");
		String deleteButtonLoc = properties.getProperty("delete_Button.Locator");
		String deletePopupLoc = properties.getProperty("confirm_DeletePopUp.Locator");
		
		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(configurationDDLocator)).click();
		driver.findElement(By.xpath(reportingMethodLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(deleteButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(deletePopupLoc)).click();
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
