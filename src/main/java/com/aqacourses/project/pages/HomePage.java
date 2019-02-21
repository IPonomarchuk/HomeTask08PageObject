package com.aqacourses.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    // Web Element
    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement signInLink;

    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(divPage));
    }

    /**
     * Click on the "Sign in" link
     *
     * @return new instance of LoginPage
     */
    public LoginPage clickSignInLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        return new LoginPage(driver);
    }

}
