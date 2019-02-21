package com.aqacourses.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    // Title of the LoginPage
    private final String TITLE = "Login - My Store";

    //Web elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(divPage));
    }

    /**
     * Verify LoginPage
     */
    public void verifyLoginPage() {
        Assert.assertEquals(TITLE, driver.getTitle());
    }

    /**
     * Fill in email and password to login form and click on the "Sign in" button
     *
     * @return new instance of MyAccountPage
     */
    public MyAccountPage login() {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys("mystore@mailinator.com");
        passwordTextField.sendKeys("mystore");
        signInButton.click();
        return new MyAccountPage(driver);
    }

}
