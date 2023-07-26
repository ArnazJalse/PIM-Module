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
					"config_3.properties");
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
		String createLoginDetailsToggleLoc = properties.getProperty("createLoginDetails.Toggle.Locator");
		String usernametxtboxLoc = properties.getProperty("username_txtbox.Locator");
		String passwordtxtboxLoc = properties.getProperty("password_txtbox.Locator");
		String confirmPasswordtxtboxLoc = properties.getProperty("confirmPassword_txtbox.Locator");

		String firstName = properties.getProperty("firstName.Loc");
		String middleName = properties.getProperty("middleName.Loc");
		String lastName = properties.getProperty("LastName.Loc");
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		String confirmPassword = properties.getProperty("confirmPassword");

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
		driver.findElement(By.xpath(createLoginDetailsToggleLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(usernametxtboxLoc)).sendKeys(userName);
		driver.findElement(By.xpath(passwordtxtboxLoc)).sendKeys(password);
		driver.findElement(By.xpath(confirmPasswordtxtboxLoc)).sendKeys(confirmPassword);
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
		String nickNametxtboxLoc = properties.getProperty("nickName_txtbox.Locator");
		String otherIDtxtboxLoc = properties.getProperty("otherId_txtbox.Locator");
		String driverLicenseNumtxtboxLoc = properties.getProperty("driverLicenseNumber_txtbox.Locator");
		String expirydateCalenderLoc = properties.getProperty("expiryDate_calender.Locator");
		String SSNnumbertxtboxLoc = properties.getProperty("SSNNumber_txtbox.Locator");
		String SINNumbertxtboxLoc = properties.getProperty("SINNumber_txtbox.Locator");
		String nationalityDDLoc = properties.getProperty("nationality_DD.Locator");
		String nationalitySelectedLoc = properties.getProperty("nationality_Selected.Locator");
		String maritalStatusDDLoc = properties.getProperty("maritalStatus_DD.Locator");
		String maritalStatusSelectedLoc = properties.getProperty("maritalStatus_Selected.Locator");
		String genderCheckboxLoc = properties.getProperty("gender_checkbox.Locator");
		String DOBCalenderLoc = properties.getProperty("DOB_calender.Locator");
		String militryServicetxtboxLoc = properties.getProperty("militryService_txtbox.Locator");
		String updateSaveButtonLoc = properties.getProperty("updatesave_button.Locator");
		String bloodtypeDDLoc = properties.getProperty("bloodtype_DD.Locator");
		String bloodtypeSelectedLoc = properties.getProperty("bloodtypr_Selected.Locator");
		String updateSaveButton1Loc = properties.getProperty("updatesave_button1.Locator");
		String jobLinkLoc = properties.getProperty("job_link.Locator");
		String jobTitleDDLoc = properties.getProperty("job_title.Locator");
		String jobTitleSelectLoc = properties.getProperty("jobTitle_select.Locator");
		String saveButtonLoc = properties.getProperty("jobSave_button.Locator");

		String firstName = properties.getProperty("firstName.Loc");
		String nickName = properties.getProperty("nickName");
		String otherID = properties.getProperty("otherId");
		String DriverLicenseNumber = properties.getProperty("DriverLicenseNumber");
		String expiryDate = properties.getProperty("expirydate");
		String SSNNumber = properties.getProperty("SSNNumber");
		String SINNumber = properties.getProperty("SINNumber");
		String DOB = properties.getProperty("DOB");
		String militryService = properties.getProperty("militryService");
		
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
		driver.findElement(By.xpath(nickNametxtboxLoc)).sendKeys(nickName);
		driver.findElement(By.xpath(otherIDtxtboxLoc)).sendKeys(otherID);
		driver.findElement(By.xpath(driverLicenseNumtxtboxLoc)).sendKeys(DriverLicenseNumber);
		driver.findElement(By.xpath(expirydateCalenderLoc)).sendKeys(expiryDate);
		driver.findElement(By.xpath(SSNnumbertxtboxLoc)).sendKeys(SSNNumber);
		driver.findElement(By.xpath(SINNumbertxtboxLoc)).sendKeys(SINNumber);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(nationalityDDLoc)).click();
		driver.findElement(By.xpath(nationalitySelectedLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(maritalStatusDDLoc)).click();
		driver.findElement(By.xpath(maritalStatusSelectedLoc)).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(DOBCalenderLoc)).sendKeys(DOB);
		driver.findElement(By.xpath(genderCheckboxLoc)).click();
		driver.findElement(By.xpath(militryServicetxtboxLoc)).sendKeys(militryService);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(updateSaveButtonLoc)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(bloodtypeDDLoc)).click();
		driver.findElement(By.xpath(bloodtypeSelectedLoc)).click();
		driver.findElement(By.xpath(updateSaveButton1Loc)).click();
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

		String firstName = properties.getProperty("firstName.Loc");

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
