package com.saucedemo.pages;

import com.saucedemo.driver.Driver;
import com.saucedemo.utilities.ReadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class Login_Pages extends Driver {
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username_Field;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password_Field;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement login_button;
	
	public Login_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo_LoginUI() {
		driver.get(prop.getProperty("URL"));
	}

	public void setUsername_Field(String value) {
		username_Field.sendKeys(value);
	}

	public void password_Input_Field(String value) {
		password_Field.sendKeys(value);
	}

	public void click_login_Button() {
		login_button.click();
	}
}
