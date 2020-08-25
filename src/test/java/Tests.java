import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalPage;
import utils.BaseHooks;
import utils.Variables;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests extends BaseHooks {
    private static Logger logger = LogManager.getLogger(Tests.class);
    private void loginAndGoToPersonalPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        mainPage.goToPersonalPage();
    }

    @Test
    public void BeforeTest() {
        logger.info("Filling information");
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.fillInfo();
    }

    @Test
    public void CheckFirstName() {
        logger.info("Checking First Name");
        String expected = Variables.first_name;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getFisrtName();
        assertEquals(expected, text);
    }

    @Test
    public void CheckLastName() {
        logger.info("Checking Last Name");
        String expected = Variables.last_name;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getLastName();
        assertEquals(expected, text);
    }

    @Test
    public void CheckFirstNameRus() {
        logger.info("Checking First Name (Russian)");
        String expected = Variables.first_name_rus;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getFirstNameRus();
        assertEquals(expected, text);
    }

    @Test
    public void CheckLastNameRus() {
        logger.info("Checking Last Name (Russian)");
        String expected = Variables.last_name_rus;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getLastNameRus();
        assertEquals(expected, text);
    }

    @Test
    public void CheckBirthday() {
        logger.info("Checking Birthday");
        String expected = Variables.birthday;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getBirthday();
        assertEquals(expected, text);
    }

    @Test
    public void CheckCountry() {
        logger.info("Checking Country");
        String expected = Variables.country;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getCountry();
        assertEquals(expected, text);
    }

    @Test
    public void CheckCity() {
        logger.info("Checking City");
        String expected = Variables.city;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getCity();
        assertEquals(expected, text);
    }

    @Test
    public void CheckLevel() {
        logger.info("Checking English Level");
        String expected = Variables.level;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getLevel();
        assertEquals(expected, text);
    }

    @Test
    public void CheckContact1() {
        logger.info("Checking Contact #1");
        String expected = Variables.contact1;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getContact1();
        assertEquals(expected, text);
    }

    @Test
    public void CheckContact2() {
        logger.info("Checking Contact #2");
        String expected = Variables.contact2;
        loginAndGoToPersonalPage();
        PersonalPage personalPage = new PersonalPage(driver);
        String text = personalPage.getContact2();
        assertEquals(expected, text);
    }
}
