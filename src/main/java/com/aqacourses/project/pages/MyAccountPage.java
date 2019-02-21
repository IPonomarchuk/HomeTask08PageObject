package com.aqacourses.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends AbstractPage {

    // User name
    private final String MY_NAME = "MyTestFirstName MyTestLastName";

    // Web elements
    @FindBy(xpath = "//div/a[@class='account']")
    private WebElement name;

    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor
     *
     * @param driver
     */
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(divPage));
    }

    /**
     * Verify name
     */
    public void verifyName() {
        Assert.assertEquals("Name isn't correct", MY_NAME, name.getText());
    }

}
