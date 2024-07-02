package com.saucedemo.pages;

import com.saucedemo.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverView_Pages extends Driver {

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finish_Button;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement orderComplete_Msg;

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement gotoHomePage_Button;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    WebElement totalPrice_Text;

    public CheckoutOverView_Pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickFinish_Button() {
        finish_Button.click();
    }

    public String check_OrderConfirmationMessage() {
        return orderComplete_Msg.getText();
    }

    public void clickGoToHomePage_Button() {
        gotoHomePage_Button.click();
    }

    public String fetchTotalPrice() {
        return totalPrice_Text.getText();
    }
}
