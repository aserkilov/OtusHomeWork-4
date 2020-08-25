package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private String username = System.getProperty("username");
    private String password = System.getProperty("password");
    private By user = By.cssSelector(".js-email-input[placeholder='Электронная почта']");
    private By pass = By.cssSelector(".js-psw-input");
    private By login_btn = By.cssSelector(".new-log-reg__login .new-input-line_last");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        driver.findElement(user).sendKeys(username);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(login_btn).click();
    }
}
