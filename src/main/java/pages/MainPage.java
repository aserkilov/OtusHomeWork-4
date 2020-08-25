package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    private static final String URL = "https://otus.ru/";
    private By auth = By.cssSelector("button.header2__auth");
    private By menu = By.cssSelector(".header2-menu__item_dropdown_no-border");
    private By subMenu = By.cssSelector(".header2-menu__dropdown-text");
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(URL);
        return this;
    }

    public void goToLoginPage() {
        driver.findElement(auth).click();
    }

    public void goToPersonalPage() {
        WebElement menuEl = driver.findElement(menu);
        Actions actions = new Actions(driver);
        actions.moveToElement(menuEl).perform();
        WebElement subMenuEl = driver.findElement(subMenu);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(subMenu));
        subMenuEl.click();
    }
}
