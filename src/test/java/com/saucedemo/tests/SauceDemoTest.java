package com.saucedemo.tests;

import com.saucedemo.driver.Driver;
import com.saucedemo.pages.*;
import com.saucedemo.utilities.ReadPropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import static com.saucedemo.driver.Driver.driver;

public class SauceDemoTest {

    public static final String filename = null;
    public ReadPropertiesFile readfile = new ReadPropertiesFile();
    public Properties prop = readfile.readPropertiesFile(filename);

    public Login_Pages login_pages;

    public Product_Pages productPages;

    public Cart_Pages cartPages;

    public CheckoutInfo_Pages checkoutInfoPages;

    public CheckoutOverView_Pages checkoutOverViewPages;

    @BeforeClass
    public void setUp() {
        Driver.init(prop.getProperty("Browser"));
    }

    @BeforeMethod
    public void initiatePageClass(){
        login_pages = new Login_Pages(driver);
        productPages = new Product_Pages(driver);
        cartPages = new Cart_Pages(driver);
        checkoutInfoPages = new CheckoutInfo_Pages(driver);
        checkoutOverViewPages = new CheckoutOverView_Pages(driver);
    }

    @Test(priority = 1)
    public void loginFunctionality() {
        login_pages.navigateTo_LoginUI();
        login_pages.setUsername_Field("standard_user");
        login_pages.password_Input_Field("secret_sauce");
        login_pages.click_login_Button();
        boolean flag = productPages.display_productPage_Text();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void buyProducts() {
        productPages.backPack_addToCart();
        productPages.bikeLight_addToCart();
        productPages.boltTShirt_addToCart();
        productPages.click_Cart_Button();
        cartPages.removeSauceLabsBackpackFromCart();
        cartPages.click_checkout_button();
        checkoutInfoPages.enterFirstName("ABC");
        checkoutInfoPages.enterLastName("XYZ");
        checkoutInfoPages.enterPostalCode("123123");
        checkoutInfoPages.clickContinue_Button();
        checkoutOverViewPages.clickFinish_Button();
        String confirmation_Message = checkoutOverViewPages.check_OrderConfirmationMessage();
        Assert.assertEquals(confirmation_Message,"Thank you for your order!");
        checkoutOverViewPages.clickGoToHomePage_Button();
    }

    @Test(priority = 3)
    public void buyProductsRanging_30to60Dollars() {
        productPages.backPack_addToCart();
        productPages.bikeLight_addToCart();
        productPages.boltTShirt_addToCart();
        productPages.click_Cart_Button();
        cartPages.removeSauceLabsBackpackFromCart();
        cartPages.click_checkout_button();
        checkoutInfoPages.enterFirstName("ABC");
        checkoutInfoPages.enterLastName("XYZ");
        checkoutInfoPages.enterPostalCode("123123");
        checkoutInfoPages.clickContinue_Button();
        String totalPrice = checkoutOverViewPages.fetchTotalPrice();
        double price = Double.parseDouble(totalPrice.replace("Total: $", ""));

        // Break the loop if total is between $30 and $60
        if (price >= 30 && price <= 60) {
            checkoutOverViewPages.clickFinish_Button();
            checkoutOverViewPages.clickFinish_Button();
            String confirmation_Message = checkoutOverViewPages.check_OrderConfirmationMessage();
            Assert.assertEquals(confirmation_Message,"Thank you for your order!");
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot ts = (TakesScreenshot) driver;
            File file = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file,new File(System.getProperty("user.dir") + "\\screenshots\\Test.PNG"));
        }
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
