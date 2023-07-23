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

public class EmployeeMgmt {
	private WebDriver driver;
	private Properties properties;
	private String baseUrl;

	
	@BeforeTest
	public void setUp() {
		try {
			// Load the properties file
			FileInputStream file = new FileInputStream(
					"/Users/arbazjalse/test/arnazWork/PIM_Module/src/test/resources/configs/config_3.properties");
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
	public void addEmployee() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String addEmployeeLoc = properties.getProperty("addEmployee.Locator");
		String firstNameTextboxLoc = properties.getProperty("firstName.textbox.Locator");
		String middleNameTextboxLoc = properties.getProperty("middleName.textbox.Locator");
		String lastNameTextboxLoc = properties.getProperty("LastName.textbox.Locator");
		String saveButtonLoc = properties.getProperty("save_button.Locator");
		// Get locators from properties
		String adminNameDDLoc = properties.getProperty("adminName_DD.Loc");
		String logoutLinkLoc = properties.getProperty("logout_link.Loc");

		String firstName = properties.getProperty("firstName.Loc");
		String middleName = properties.getProperty("middleName.Loc");
		String lastName = properties.getProperty("LastName.Loc");

		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(addEmployeeLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.name(firstNameTextboxLoc)).sendKeys(firstName);
		driver.findElement(By.name(middleNameTextboxLoc)).sendKeys(middleName);
		driver.findElement(By.name(lastNameTextboxLoc)).sendKeys(lastName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(saveButtonLoc)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@Test(priority = 2)
	public void UpdateEmployee() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String searchNametxtboxLoc = properties.getProperty("searchEmpName_textbox.Locator");
		String searchButtonLoc = properties.getProperty("search_button.Locator");
		String updateButtonLoc = properties.getProperty("update_button.Locator");
		String updatefirstNameLoc = properties.getProperty("updatefirstName_txtbox.Locator");
		String updateSaveButtonLoc = properties.getProperty("updatesave_button.Locator");
		String jobLinkLoc = properties.getProperty("job_link.Locator");
		String jobTitleDDLoc = properties.getProperty("job_title.Locator");
		String jobTitleSelectLoc = properties.getProperty("jobTitle_select.Locator");
		String saveButtonLoc = properties.getProperty("jobSave_button.Locator");

		String firstName = properties.getProperty("firstName.Loc");
		String updateFirstName = properties.getProperty("updateFirstName.Loc");
		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(searchNametxtboxLoc)).sendKeys(firstName);
		;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(searchButtonLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(updateButtonLoc)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(updatefirstNameLoc)).clear();
		driver.findElement(By.xpath(updatefirstNameLoc)).sendKeys(updateFirstName);
		driver.findElement(By.xpath(updateSaveButtonLoc)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(jobLinkLoc)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(jobTitleDDLoc)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(jobTitleSelectLoc)).click();
		driver.findElement(By.xpath(saveButtonLoc)).click();

	}

	@Test(priority = 3)
	public void deleteEmployee() {
		// Get locators from properties
		String PIMLocator = properties.getProperty("PIM_Menu.Locator");
		String searchNametxtboxLoc = properties.getProperty("searchEmpName_textbox.Locator");
		String searchButtonLoc = properties.getProperty("search_button.Locator");
		String deleteButtonLoc = properties.getProperty("delete_button.Locator");
		String confirmDeletePopupLoc = properties.getProperty("confirm_deletepopup.Locator");

		String updateFirstName = properties.getProperty("updateFirstName.Loc");

		driver.findElement(By.xpath(PIMLocator)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(searchNametxtboxLoc)).sendKeys(updateFirstName);
		;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(searchButtonLoc)).click();
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
		driver.findElement(By.xpath(confirmDeletePopupLoc)).click();
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
