package com.aqacourses.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    // Web Elements
    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//div/a[@class='logout']")
    private WebElement singOutButton;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;


    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     *
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
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

    /**
     * Click on the "Sign out" button
     *
     * @return new instance of LoginPage
     */
    public LoginPage logout() {
        wait.until(ExpectedConditions.elementToBeClickable(singOutButton)).click();
        return new LoginPage(driver);
    }

}
