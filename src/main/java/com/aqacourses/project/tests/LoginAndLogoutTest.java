package com.aqacourses.project.tests;

import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.pages.LoginPage;
import com.aqacourses.project.pages.MyAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginAndLogoutTest {

    // URL to open and test
    private final String URL = "http://automationpractice.com/index.php";

    // Instance of WebDriver
    private WebDriver driver;

    /**
     * Set up method to initialize driver
     */
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * Open site and click on the "Sign in" link, fill in email and password to login form and click on the "Sign in" button
     * Verify name, click on the "Sign out" button and verify LoginPage after logout
     */
    @Test
    public void testLoginAndLogoutTest() {

        // Open site
        driver.get(URL);

        // Initialize Home page
        HomePage homePage = new HomePage(driver);

        // Click on the "Sign in" link
        LoginPage loginPage = homePage.clickSignInLink();

        // Fill in email and password to login form and click on the "Sign in" button
        MyAccountPage myAccountPage = loginPage.login();

        // Verify name
        myAccountPage.verifyName();

        // Click on the "Sign out" button
        LoginPage loginPageAfterLogout = myAccountPage.logout();

        // Verify LoginPage after logout
        loginPageAfterLogout.verifyLoginPage();
    }

    /**
     * Quit WebDriver
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}
