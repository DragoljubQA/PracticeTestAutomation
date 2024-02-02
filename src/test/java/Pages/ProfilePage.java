package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //----------------------------------

    @FindBy(linkText = "Log out")
    public WebElement logoutButton;

    @FindBy(className = "post-title")
    public WebElement title;

    //-----------------------------------

    public void clickOnLogout() {
        logoutButton.click();
    }

}
