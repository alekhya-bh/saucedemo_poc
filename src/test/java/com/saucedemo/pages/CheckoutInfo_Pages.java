package com.saucedemo.pages;

import com.saucedemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfo_Pages extends Driver {

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstName_TextField;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastName_TextField;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCode_TextField;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continue_Button;

    public CheckoutInfo_Pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        firstName_TextField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastName_TextField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCode_TextField.sendKeys(postalCode);
    }

    public void clickContinue_Button() {
        continue_Button.click();
    }
}
