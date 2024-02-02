package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //-------------------------------

    @FindBy(id = "menu-item-20")
    public WebElement practiceButton;

    @FindBy(linkText = "Test Login Page")
    public WebElement linkToLoginPage;

    //-----------------------------

    public void clickOnPractice() {
        practiceButton.click();
    }

    public void clickOnLinkToLoginPage() {
        linkToLoginPage.click();
    }


}
