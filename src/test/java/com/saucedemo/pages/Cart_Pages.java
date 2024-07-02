package com.saucedemo.pages;

import com.saucedemo.driver.Driver;
import com.saucedemo.utilities.ReadPropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class Cart_Pages extends Driver {

    public static final String filename = null;
    public ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
    public Properties prop = readPropertiesFile.readPropertiesFile(filename);

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    WebElement remove_Button;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout_Button;

    public Cart_Pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void removeSauceLabsBackpackFromCart() {
        remove_Button.click();
    }

    public void click_checkout_button() {
        checkout_Button.click();
    }
}
