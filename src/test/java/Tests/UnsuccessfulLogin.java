package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnsuccessfulLogin extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driverThreadLocal.set(driver);
        driver = driverThreadLocal.get();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }
    @Test
    public void invalidUsername() {
       homePage.clickOnPractice();
        homePage.clickOnLinkToLoginPage();
        loginPage.inputUsername("student1");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.submitButton.isDisplayed());
        Assert.assertTrue(loginPage.error.isDisplayed());
    }

    @Test
    public void invalidPassword() {
        homePage.clickOnPractice();
        homePage.clickOnLinkToLoginPage();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password");
        loginPage.clickOnSubmit();
        Assert.assertTrue(loginPage.submitButton.isDisplayed());
        Assert.assertTrue(loginPage.error.isDisplayed());
    }

}
