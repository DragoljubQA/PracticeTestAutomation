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

public class LoginLogout extends BaseTest {

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
    public void loginTest() {
        homePage.clickOnPractice();
        homePage.clickOnLinkToLoginPage();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        Assert.assertTrue(profilePage.logoutButton.isDisplayed());
        Assert.assertTrue(profilePage.title.isDisplayed());
    }

    @Test
    public void logoutTest() {
        homePage.clickOnPractice();
        homePage.clickOnLinkToLoginPage();
        loginPage.inputUsername("student");
        loginPage.inputPassword("Password123");
        loginPage.clickOnSubmit();
        profilePage.clickOnLogout();
        Assert.assertTrue(loginPage.submitButton.isDisplayed());
    }

}
