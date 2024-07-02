package com.saucedemo.pages;

import com.saucedemo.driver.Driver;
import com.saucedemo.utilities.ReadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class Product_Pages extends Driver {
	public static final String filename = null;
	public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
	public Properties prop = readPropertiesFile.readPropertiesFile(filename);

	@FindBy(xpath = "//span[@class='title']")
	WebElement products_Text;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement sauce_labs_backpack_AddToCart_Button;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement sauce_labs_bikeLight_AddToCart_Button;

	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	WebElement sauce_labs_boltTShirt_AddToCart_Button;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cart_Button;

	public Product_Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean display_productPage_Text() {
		return products_Text.isDisplayed();
	}

	public void backPack_addToCart() {
		sauce_labs_backpack_AddToCart_Button.click();
	}

	public void bikeLight_addToCart() {
		sauce_labs_bikeLight_AddToCart_Button.click();
	}

	public void boltTShirt_addToCart() {
		sauce_labs_boltTShirt_AddToCart_Button.click();
	}

	public void click_Cart_Button() {
		cart_Button.click();
	}
}
