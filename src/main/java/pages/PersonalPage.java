package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Variables;

public class PersonalPage extends AbstractPage {
    private static Logger logger = LogManager.getLogger(PersonalPage.class);
    String first_name = Variables.first_name;
    String last_name = Variables.last_name;
    String first_name_rus = Variables.first_name_rus;
    String last_name_rus = Variables.last_name_rus;
    String birthday = Variables.birthday;
    String contact1 = Variables.contact1;
    String contact2 = Variables.contact2;
    String country = Variables.country;
    String city = Variables.city;
    String level = Variables.level;
    private By fname_latin = By.cssSelector("#id_fname_latin");
    private By lname_latin = By.cssSelector("#id_lname_latin");
    private By fname = By.cssSelector("#id_fname");
    private By lname = By.cssSelector("#id_lname");
    private By birth = By.cssSelector("[title='День рождения']");
    private By cont1 = By.cssSelector("#id_contact-0-value");
    private By add_contact = By.cssSelector("[data-prefix='contact'] .js-formset-add");
    private By cont2 = By.cssSelector("#id_contact-1-value");
    private By country_dropdown = By.xpath("//input[@name='country']/../div");
    private By country_dropdown_option = By.cssSelector("[title='" + country + "']");
    private By city_dropdown = By.xpath("//input[@name='city']/../div");
    private By city_dropdown_option = By.cssSelector("[title='" + city + "']");
    private By level_dropdown = By.xpath("//input[@name='english_level']/../div");
    private By level_dropdown_option = By.cssSelector("[title='" + level + "']");
    private By contact1_dropdown = By.xpath("//input[@name='contact-0-service']/../div");
    private By contact1_dropdown_option = By.cssSelector("[title='Facebook']");
    private By contact2_dropdown = By.xpath("//input[@name='contact-1-service']/../div");
    private By contact2_dropdown_option = By.cssSelector("[data-num='1'] [title='VK']");
    private By save = By.cssSelector("[name='continue']");

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    private void clickAndSelect(By dropdown, By option) {
        Actions actions = new Actions(driver);
        WebElement list = driver.findElement(dropdown);
        actions.moveToElement(list).perform();
        list.click();
        driver.findElement(option).click();
    }

    public void fillInfo() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(fname_latin).clear();
        driver.findElement(fname_latin).sendKeys(first_name);
        driver.findElement(lname_latin).clear();
        driver.findElement(lname_latin).sendKeys(last_name);
        driver.findElement(fname).clear();
        driver.findElement(fname).sendKeys(first_name_rus);
        driver.findElement(lname).clear();
        driver.findElement(lname).sendKeys(last_name_rus);
        driver.findElement(birth).clear();
        driver.findElement(birth).sendKeys(birthday);
        WebElement city_dropdown_element = driver.findElement(city_dropdown);
        clickAndSelect(country_dropdown, country_dropdown_option);
        clickAndSelect(city_dropdown, city_dropdown_option);
        clickAndSelect(level_dropdown, level_dropdown_option);
        clickAndSelect(contact1_dropdown, contact1_dropdown_option);
        driver.findElement(add_contact).click();
        clickAndSelect(contact2_dropdown, contact2_dropdown_option);
        driver.findElement(cont1).clear();
        driver.findElement(cont1).sendKeys(contact1);
        driver.findElement(cont2).clear();
        driver.findElement(cont2).sendKeys(contact2);
        driver.findElement(save).click();
    }

    public String getFisrtName() {
        String text = driver.findElement(fname_latin).getAttribute("value");
        return text;
    }

    public String getLastName() {
        String text = driver.findElement(lname_latin).getAttribute("value");
        return text;
    }

    public String getFirstNameRus() {
        String text = driver.findElement(fname).getAttribute("value");
        return text;
    }

    public String getLastNameRus() {
        String text = driver.findElement(lname).getAttribute("value");
        return text;
    }

    public String getBirthday() {
        String text = driver.findElement(birth).getAttribute("value");
        return text;
    }

    public String getCountry() {
        String text = driver.findElement(country_dropdown).getText();
        return text;
    }

    public String getCity() {
        String text = driver.findElement(city_dropdown).getText();
        return text;
    }

    public String getLevel() {
        String text = driver.findElement(level_dropdown).getText();
        return text;
    }

    public String getContact1() {
        String text = driver.findElement(cont1).getAttribute("value");
        return text;
    }

    public String getContact2() {
        String text = driver.findElement(cont2).getAttribute("value");
        return text;
    }
}
